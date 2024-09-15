package my.study.feat.root;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@Path("/")
public class RootResource {

    @GET
    public Response getRoot() {
        return Response.ok("MS1 OK!").build();
    }

}
