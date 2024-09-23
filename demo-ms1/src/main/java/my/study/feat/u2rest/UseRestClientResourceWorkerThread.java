package my.study.feat.u2rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/worker-thread/use/rest")
public class UseRestClientResourceWorkerThread {

    @GET
    public Response myselfInternal() {
        var dto = new RestClientDTO();
        dto.setId(UUID.randomUUID().toString());
        return Response.ok(dto).build();
    }

}
