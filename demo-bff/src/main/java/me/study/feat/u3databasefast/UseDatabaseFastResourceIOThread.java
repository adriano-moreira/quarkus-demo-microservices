package me.study.feat.u3databasefast;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/io-thread/use/database-fast")
public class UseDatabaseFastResourceIOThread {

    @RestClient
    MS1DatabaseFastRestClientIOThread randomClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> random() {
        return randomClient.random()
                .map(resp -> Response.ok(resp).build());
    }

}
