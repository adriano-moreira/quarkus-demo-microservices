package me.study.feat.ping;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/ping")
public class PingResource {

    @RestClient
    MS1PingRestClient pingRestClient;

    @GET
    public Response ping() {
        Log.info("into bff GET /ping ");
        var response = pingRestClient.ping();
        return Response.ok(response).build();
    }

}
