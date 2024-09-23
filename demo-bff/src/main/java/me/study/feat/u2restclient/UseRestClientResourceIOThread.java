package me.study.feat.u2restclient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/io-thread/use/rest-client")
public class UseRestClientResourceIOThread {

    @RestClient
    MS1RestClientIOThread restClient;

    @GET
    public Uni<Response> myselfInternal() {
        return restClient.get()
                .flatMap(dto -> restClient.get())
                .flatMap(dto -> restClient.get())
                .map(dto -> Response.ok().build());
    }

}
