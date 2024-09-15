package me.study.feat.myself;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/io-thread/myself-internal")
@RegisterRestClient(configKey = "myself")
public interface MySelfRestClientIOThread {

    @GET
    Uni<MySelfDTO> myselfInternal();

}
