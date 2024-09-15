package me.study.feat.nothing;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/nothing")
public class NothingResource {

    @GET
    public Response doNothing() {
        return Response.ok().build();
    }

}
