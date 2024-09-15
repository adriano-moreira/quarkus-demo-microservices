package me.study.feat.myself;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/virtual-thread/myself")
public class MySelfResourceVirtualThread {

    @RestClient
    MySelfRestClientVirtualThread restClient;

    @GET
    @RunOnVirtualThread
    public Response myselfInternal() {
//        Log.info("into bff GET /virtual-thread/myself");
        var dto = restClient.myselfInternal();
        return Response.ok(dto).build();
    }

}
