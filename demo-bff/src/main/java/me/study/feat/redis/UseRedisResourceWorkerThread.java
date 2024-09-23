package me.study.feat.redis;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/worker-thread/use/redis")
public class UseRedisResourceWorkerThread {

    @RestClient
    MS1UseRedisRestClientWorkerThread restClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response random() {
        var random = restClient.useRedis();
        return Response.ok(random).build();
    }
}
