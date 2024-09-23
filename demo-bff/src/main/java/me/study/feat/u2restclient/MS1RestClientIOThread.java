package me.study.feat.u2restclient;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/io-thread/use/rest")
@RegisterRestClient(configKey = "ms1")
public interface MS1RestClientIOThread {

    @GET
    Uni<RestClientDTO> get();

}
