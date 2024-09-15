package me.study.feat.myself;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/io-thread/myself")
public class MySelfResourceIOThread {

    @RestClient
    MySelfRestClientIOThread restClient;

    @GET
    public Uni<Response> myselfInternal() {
//        Log.info("into bff GET /io-thread/myself");
        return restClient.myselfInternal()
                .map(dto -> Response.ok(dto).build());
    }

}
