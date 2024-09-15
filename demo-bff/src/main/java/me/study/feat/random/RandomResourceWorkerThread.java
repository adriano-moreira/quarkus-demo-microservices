package me.study.feat.random;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/worker-thread/random")
public class RandomResourceWorkerThread {

    @RestClient
    MS1RandomRestClient randomClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response random() {
        Log.info("into bff GET /worker-thread/random");
        var random = randomClient.random();
        return Response.ok(random).build();
    }
}
