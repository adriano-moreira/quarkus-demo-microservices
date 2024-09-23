package me.study.feat.u3databasefast;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/worker-thread/use/database-fast")
@RegisterRestClient(configKey = "ms1")
public interface MS1DatabaseFastRestClientWorkerThread {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    DataBaseFastDTO random();

}
