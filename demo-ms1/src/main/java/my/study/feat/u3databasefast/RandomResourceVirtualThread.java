package my.study.feat.u3databasefast;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/virtual-thread/user/database-fast")
public class RandomResourceVirtualThread {

    private final RandomRepository randomRepository;

    public RandomResourceVirtualThread(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public RandomDTO getRandom() {
        randomRepository.getRandom();
        randomRepository.getRandom();
        randomRepository.getRandom();
        return randomRepository.getRandom();
    }

}
