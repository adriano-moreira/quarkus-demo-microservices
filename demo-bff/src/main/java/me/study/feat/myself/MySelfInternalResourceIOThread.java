package me.study.feat.myself;

import io.quarkus.logging.Log;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

import java.util.UUID;

@Path("/io-thread/myself-internal")
public class MySelfInternalResourceIOThread {

    @GET
    public Uni<Response> myselfInternal() {
//        Log.info("into bff GET /io-thread/myself-internal");

        return Uni.createFrom()
                .item(() -> {
                    var dto = new MySelfDTO();
                    dto.setId(UUID.randomUUID().toString());
                    return dto;
                })
                .map(dto -> Response.ok(dto).build());

    }

}
