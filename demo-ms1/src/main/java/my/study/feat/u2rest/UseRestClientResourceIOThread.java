package my.study.feat.u2rest;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/io-thread/use/rest")
public class UseRestClientResourceIOThread {

    @GET
    public Uni<Response> myselfInternal() {
        return Uni.createFrom().item(() -> {
            var dto = new RestClientDTO();
            dto.setId(UUID.randomUUID().toString());
            return Response.ok(dto).build();
        });
    }

}
