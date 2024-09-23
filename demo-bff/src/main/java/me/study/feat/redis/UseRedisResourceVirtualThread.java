package me.study.feat.redis;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/virtual-thread/use/redis")
public class UseRedisResourceVirtualThread {

    @RestClient
    MS1UseRedisRestClientVirtualThread restClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public Response random() {
        var random = restClient.useRedis();
        return Response.ok(random).build();
    }
}
