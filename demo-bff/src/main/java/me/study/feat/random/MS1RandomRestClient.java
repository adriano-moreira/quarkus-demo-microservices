package me.study.feat.random;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/random")
@RegisterRestClient(configKey = "ms1")
public interface MS1RandomRestClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    RandomDTO random();

}
