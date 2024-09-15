package my.study.feat.error;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.InternalServerErrorException;
import jakarta.ws.rs.Path;

@Path( "/error")
public class ErrorResource {

    @GET
    @Path( "/400")
    public String e400() {
        Log.info( "into resource error/400");
        throw new InternalServerErrorException("my error 400");
    }

    @GET
    @Path( "/500")
    public String e500() {
        Log.info( "into resource error/500");
        throw new InternalServerErrorException("my error 500");
    }

}
