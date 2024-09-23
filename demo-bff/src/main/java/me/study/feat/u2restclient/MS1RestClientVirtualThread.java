package me.study.feat.u2restclient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/virtual-thread/use/rest")
@RegisterRestClient(configKey = "ms1")
public interface MS1RestClientVirtualThread {

    @GET
    RestClientDTO get();

}
