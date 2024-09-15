package me.study.feat.myself;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/worker-thread/myself-internal")
public class MySelfInternalResourceWorkerThread {

    @GET
    public Response myselfInternal() {
//        Log.info("into bff GET /worker-thread/myself-internal");
        var dto = new MySelfDTO();
        dto.setId(UUID.randomUUID().toString());
        return Response.ok(dto).build();
    }

}
