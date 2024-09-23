package my.study.feat.u2rest;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/virtual-thread/use/rest")
public class UseRestClientResourceVirtualThread {

    @GET
    @RunOnVirtualThread
    public Response myselfInternal() {
        var dto = new RestClientDTO();
        dto.setId(UUID.randomUUID().toString());
        return Response.ok(dto).build();
    }

}
