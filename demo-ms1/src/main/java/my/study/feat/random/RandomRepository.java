package my.study.feat.random;

import io.agroal.api.AgroalDataSource;
import io.opentelemetry.instrumentation.annotations.WithSpan;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;

@ApplicationScoped
public class RandomRepository {

    private final AgroalDataSource dataSource;

    public RandomRepository(AgroalDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @WithSpan
    public RandomDTO getRandom() {
        Log.info("into repository");
        final var sql = "select (random() * 1000000)::int random";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
        ) {
            RandomDTO randomDTO;
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                randomDTO = new RandomDTO();
                randomDTO.setRandom(rs.getInt(1));
            }
            randomDTO.setTime(ZonedDateTime.now());
            return randomDTO;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
