package me.study.feat.u2restclient;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/virtual-thread/use/rest-client")
public class UseRestClientResourceVirtualThread {

    @RestClient
    MS1RestClientVirtualThread restClient;

    @GET
    @RunOnVirtualThread
    public Response myselfInternal() {
        restClient.get();
        restClient.get();
        restClient.get();
        var dto = restClient.get();
        return Response.ok(dto).build();
    }

}
