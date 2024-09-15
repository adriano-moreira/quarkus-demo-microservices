package me.study.feat.ping;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/ping")
@RegisterRestClient(configKey = "ms1")
public interface MS1PingRestClient {

    @GET
    String ping();

}
