package my.study.feat.redis;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/virtual-thread/use/redis")
public class RedisResourceVirtualThread {

    @Inject
    RedisRepository redisRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public Response getRedis() {
        var dto = UseRedisDTO.ofRandom();

        redisRepository.set(dto);
        var fromRedis = redisRepository.get(dto.getId());

        return Response.ok(fromRedis).build();
    }

}
