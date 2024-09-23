package me.study.feat.u3databasefast;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/virtual-thread/use/database-fast")
public class UseDatabaseFastResourceVirtualThread {

    @RestClient
    MS1DatabaseFastRestClientVirtualThread randomClient;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RunOnVirtualThread
    public Response random() {
        var random = randomClient.random();
        return Response.ok(random).build();
    }
}
