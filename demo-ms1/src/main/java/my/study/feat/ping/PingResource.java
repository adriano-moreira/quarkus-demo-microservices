package my.study.feat.ping;

import io.quarkus.logging.Log;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.UUID;

@Path("/ping")
public class PingResource {

    @GET
    public String ping() {
        Log.info("into ms1 GET /ping");
        return "pong:" + UUID.randomUUID();
    }

}
