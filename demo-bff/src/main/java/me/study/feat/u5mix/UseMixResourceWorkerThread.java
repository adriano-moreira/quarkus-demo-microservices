package me.study.feat.u5mix;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/worker-thread/use/mix")
public class UseMixResourceWorkerThread {

    @GET
    public Response random() {
        return Response.ok().build();
    }
}
