package me.study.feat.random;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/io-thread/random")
public class RandomResourceIOThread {

    @RestClient
    MS1RandomRestClientIOThread randomClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> random() {
        Log.info("into bff GET /io-thread/random");
        return randomClient.random()
                .map(resp -> Response.ok(resp).build());
    }

}
