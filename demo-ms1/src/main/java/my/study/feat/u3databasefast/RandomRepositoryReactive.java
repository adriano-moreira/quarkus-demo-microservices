package my.study.feat.u3databasefast;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.ZonedDateTime;

@ApplicationScoped
public class RandomRepositoryReactive {

    private final PgPool pgPool;

    public RandomRepositoryReactive(PgPool pgPool) {
        this.pgPool = pgPool;
    }

    public Uni<RandomDTO> getRandom() {
        Log.info("into repository");
        final var sql = "select (random() * 1000000)::int random";

        return pgPool
                .preparedQuery(sql).execute()
                .map(rs -> {
                    RandomDTO dto = new RandomDTO();
                    dto.setRandom(rs.iterator().next().getInteger("random"));
                    dto.setTime(ZonedDateTime.now());
                    return dto;
                });
    }

}
