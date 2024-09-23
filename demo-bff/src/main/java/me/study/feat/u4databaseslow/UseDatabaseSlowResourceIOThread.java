package me.study.feat.u4databaseslow;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/io-thread/use/database-slow")
public class UseDatabaseSlowResourceIOThread {

    @RestClient
    MS1DatabaseSlowRestClientIOThread restClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> random() {
        return restClient.random()
                .map(resp -> Response.ok(resp).build());
    }

}
