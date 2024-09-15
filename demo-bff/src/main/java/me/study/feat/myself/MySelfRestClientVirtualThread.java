package me.study.feat.myself;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/virtual-thread/myself-internal")
@RegisterRestClient(configKey = "myself")
public interface MySelfRestClientVirtualThread {

    @GET
    MySelfDTO myselfInternal();

}
