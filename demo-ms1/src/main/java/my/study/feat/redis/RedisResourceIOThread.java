package my.study.feat.redis;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/io-thread/use/redis")
public class RedisResourceIOThread {

    @Inject
    RedisRepositoryReactive redisRepositoryReactive;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getRedis() {
        var dto = UseRedisDTO.ofRandom();

        return redisRepositoryReactive.set(dto)
                .flatMap(v -> redisRepositoryReactive.get(dto.getId()))
                .map(dtoFromRedis -> Response.ok(dtoFromRedis).build());
    }

}
