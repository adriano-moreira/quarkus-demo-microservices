package me.study.feat.redis;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/worker-thread/use/redis")
@RegisterRestClient(configKey = "ms1")
public interface MS1UseRedisRestClientWorkerThread {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    UseRedisDTO useRedis();

}
