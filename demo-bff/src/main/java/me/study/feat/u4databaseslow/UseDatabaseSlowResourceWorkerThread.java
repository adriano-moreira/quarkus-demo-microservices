package me.study.feat.u4databaseslow;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/worker-thread/use/database-slow")
public class UseDatabaseSlowResourceWorkerThread {

    @RestClient
    MS1DatabaseSlowRestClientWorkerThread restClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response random() {
        var random = restClient.random();
        return Response.ok(random).build();
    }
}
