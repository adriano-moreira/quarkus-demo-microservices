package me.study.feat.u2restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/worker-thread/use/rest-client")
public class UseRestClientResourceWorkerThread {

    @RestClient
    MS1RestClientWorkerThread restClient;

    @GET
    public Response myselfInternal() {
        restClient.get();
        restClient.get();
        restClient.get();
        var dto = restClient.get();
        return Response.ok(dto).build();
    }

}
