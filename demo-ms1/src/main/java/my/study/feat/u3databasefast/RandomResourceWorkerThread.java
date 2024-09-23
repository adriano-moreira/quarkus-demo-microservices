package my.study.feat.u3databasefast;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/worker-thread/use/database-fast")
public class RandomResourceWorkerThread {

    private final RandomRepository randomRepository;

    public RandomResourceWorkerThread(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RandomDTO getRandom() {
        randomRepository.getRandom();
        randomRepository.getRandom();
        randomRepository.getRandom();
        return randomRepository.getRandom();
    }

}
