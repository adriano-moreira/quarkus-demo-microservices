package my.study.feat.random;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/random")
public class RandomResource {

    private final RandomRepository randomRepository;

    public RandomResource(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RandomDTO getRandom() {
        Log.info("into resource");
        return randomRepository.getRandom();
    }

}
