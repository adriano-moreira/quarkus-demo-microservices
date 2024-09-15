package my.study.feat.dbslow;

import io.agroal.api.AgroalDataSource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.PreparedStatement;

@ApplicationScoped
public class DbSlowRepository {

    @Inject
    AgroalDataSource dataSource;

    public DbSlowDto run(Integer delayInMs) {
        String sql = """
                SELECT
                    clock_timestamp() before,
                    pg_sleep(?) sleep,
                    clock_timestamp() after
                """;

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)
        ) {
            ps.setDouble(1, delayInMs / 1000.0);
            try (var rs = ps.executeQuery()) {
                rs.next();
                DbSlowDto dbSlowDto = new DbSlowDto();
                dbSlowDto.setBefore(rs.getTimestamp(1));
                dbSlowDto.setAfter(rs.getTimestamp(3));
                return dbSlowDto;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
