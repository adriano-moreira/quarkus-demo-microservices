package me.study.feat.random;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/virtual-thread/random")
public class RandomResourceVirtualThread {

    @RestClient
    MS1RandomRestClient randomClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public Response random() {
        Log.info("into bff GET /virtual-thread/random");
        var random = randomClient.random();
        return Response.ok(random).build();
    }
}
