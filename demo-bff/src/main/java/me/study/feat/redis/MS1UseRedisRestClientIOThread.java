package me.study.feat.redis;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/io-thread/use/redis")
@RegisterRestClient(configKey = "ms1")
public interface MS1UseRedisRestClientIOThread {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<UseRedisDTO> useRedis();

}
