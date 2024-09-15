package me.study.feat.myself;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.UUID;

@Path("/worker-thread/myself")
public class MySelfResourceWorkerThread {

    @RestClient
    MySelfRestClientWorkerThread restClient;

    @GET
    public Response myselfInternal() {
//        Log.info("into bff GET /worker-thread/myself");
        var dto = restClient.myselfInternal();
        return Response.ok(dto).build();
    }

}
