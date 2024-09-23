package me.study.feat.u1nothing;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/virtual-thread/use/nothing")
public class UseNothingResourceVirtualThread {

    @GET
    @RunOnVirtualThread
    public Response doNothing() {
        return Response.ok().build();
    }

}
