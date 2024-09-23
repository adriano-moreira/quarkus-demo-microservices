package me.study.feat.u5mix;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/virtual-thread/use/mix")
public class UseMixResourceVirtualThread {

    @GET
    @RunOnVirtualThread
    public Response random() {
        return Response.ok().build();
    }

}
