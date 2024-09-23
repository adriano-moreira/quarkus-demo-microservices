package my.study.feat.u3databasefast;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/io-thread/use/database-fast")
public class RandomResourceIOThread {

    private final RandomRepositoryReactive randomRepository;

    public RandomResourceIOThread(RandomRepositoryReactive randomRepository) {
        this.randomRepository = randomRepository;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<RandomDTO> getRandom() {
        return randomRepository.getRandom()
                .flatMap(r -> randomRepository.getRandom())
                .flatMap(r -> randomRepository.getRandom())
                .flatMap(r -> randomRepository.getRandom());
    }

}
