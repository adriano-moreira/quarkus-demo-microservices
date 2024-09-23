package me.study.feat.u3databasefast;

import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/io-thread/use/database-fast")
@RegisterRestClient(configKey = "ms1")
public interface MS1DatabaseFastRestClientIOThread {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Uni<DataBaseFastDTO> random();

}
