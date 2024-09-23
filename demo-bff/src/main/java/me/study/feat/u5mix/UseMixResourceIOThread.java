package me.study.feat.u5mix;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import me.study.feat.u2restclient.MS1RestClientIOThread;
import me.study.feat.u3databasefast.MS1DatabaseFastRestClientIOThread;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/io-thread/use/mix")
public class UseMixResourceIOThread {

    @RestClient
    MS1RestClientIOThread restClient2;

    @RestClient
    MS1DatabaseFastRestClientIOThread restClient3;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> random() {
        return Uni.createFrom().item(() -> Response.ok().build());
    }

}
