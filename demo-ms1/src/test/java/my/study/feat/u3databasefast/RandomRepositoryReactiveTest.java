package my.study.feat.u3databasefast;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@Disabled
class RandomRepositoryReactiveTest {

    @Inject
    RandomRepositoryReactive randomRepositoryReactive;

    @Test
    void getRandom() {
        RandomDTO dto = randomRepositoryReactive.getRandom().await().indefinitely();
        assertNotNull(dto);
        assertNotNull(dto.getRandom());
    }
}