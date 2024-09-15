package me.study.feat.myself;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/virtual-thread/myself-internal")
public class MySelfInternalResourceVirtualThread {

    @GET
    @RunOnVirtualThread
    public Response myselfInternal() {
//        Log.info("into bff GET /virtual-thread/myself-internal");

        var dto = new MySelfDTO();
        dto.setId(UUID.randomUUID().toString());
        return Response.ok(dto).build();
    }

}
