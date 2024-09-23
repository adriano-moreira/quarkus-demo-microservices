package my.study.feat.u3databasefast;

import io.quarkus.logging.Log;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@QuarkusTest
@Disabled
class RandomRepositoryTest {

    @Inject
    RandomRepository repo;

    @Test
    void randomTest() {
        RandomDTO random = repo.getRandom();
        Assertions.assertNotNull(random);
        Assertions.assertNotNull(random.getRandom());
        Assertions.assertNotNull(random.getTime());
        Log.infov("random value is: {0}", random.getRandom());
    }
}