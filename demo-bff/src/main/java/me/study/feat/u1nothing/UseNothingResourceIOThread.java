package me.study.feat.u1nothing;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/io-thread/use/nothing")
public class UseNothingResourceIOThread {

    @GET
    public Uni<Response> doNothing() {
        return Uni.createFrom().item(Response.ok().build());
    }

}
