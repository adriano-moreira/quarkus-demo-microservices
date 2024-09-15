package me.study.feat.root;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/")
public class RootResource {

    @GET
    public Response root() {
        return Response.ok("BFF OK!").build();
    }

}
