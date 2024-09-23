package my.study.feat.u4databaseslow;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@QuarkusTest
@Disabled
class DbSlowRepositoryTest {

    @Inject
    DbSlowRepository repository;

    @Test
    void run() {
        Log.info("start");
        repository.run(2000);
        Log.info("middle");
        repository.run(100);
        Log.info("end");
    }
}