package me.study.feat.u4databaseslow;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/worker-thread/use/database-slow")
@RegisterRestClient(configKey = "ms1")
public interface MS1DatabaseSlowRestClientWorkerThread {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    DataBaseSlowDTO random();

}
