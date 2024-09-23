package me.study.feat.u1nothing;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/worker-thread/use/nothing")
public class UseNothingResourceWorkerThread {

    @GET
    public Response doNothing() {
        return Response.ok().build();
    }

}
