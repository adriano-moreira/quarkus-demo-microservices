package my.study.feat.u4databaseslow;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.ZoneOffset;
import java.util.Date;

@ApplicationScoped
public class DbSlowRepositoryReactive {

    @Inject
    PgPool pgPool;

    public Uni<DbSlowDto> run(Integer delayInMs) {
        Log.warnv("starting query in {0}", Thread.currentThread().getName());
        String sql = """
                SELECT
                    clock_timestamp() before,
                    pg_sleep($1) sleep,
                    clock_timestamp() after
                """;
        return pgPool.preparedQuery(sql).execute(Tuple.of(delayInMs / 1000.0)).map(rs -> {
            Row row = rs.iterator().next();
            DbSlowDto dbSlowDto = new DbSlowDto();
            dbSlowDto.setBefore(getDate(row, "before"));
            dbSlowDto.setAfter(getDate(row, "after"));
            return dbSlowDto;
        });
    }

    private Date getDate(Row row, String columnName) {
        return Date.from(row.getLocalDateTime(columnName).toInstant(ZoneOffset.UTC));
    }

}
