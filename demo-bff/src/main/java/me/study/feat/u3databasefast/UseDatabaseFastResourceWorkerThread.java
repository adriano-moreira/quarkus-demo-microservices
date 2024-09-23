package me.study.feat.u3databasefast;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/worker-thread/use/database-fast")
public class UseDatabaseFastResourceWorkerThread {

    @RestClient
    MS1DatabaseFastRestClientWorkerThread randomClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response random() {
        var random = randomClient.random();
        return Response.ok(random).build();
    }
}
