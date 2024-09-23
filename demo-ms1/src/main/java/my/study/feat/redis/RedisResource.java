package my.study.feat.redis;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/worker-thread/use/redis")
public class RedisResource {

    @Inject
    RedisRepository redisRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getRedis() {
        var dto = UseRedisDTO.ofRandom();

        redisRepository.set(dto);
        var fromRedis = redisRepository.get(dto.getId());

        return Response.ok(fromRedis).build();
    }

}
