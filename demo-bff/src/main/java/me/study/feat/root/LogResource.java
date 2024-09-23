package me.study.feat.root;

import io.quarkus.logging.Log;
import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/log")
@Produces(MediaType.TEXT_PLAIN)
public class LogResource {

    @GET
    public Response log() {
        Log.warn("here is in a normal/worker thread");
        var threadName = Thread.currentThread().getName();
        return Response.ok(threadName).build();
    }

    @GET
    @Path("virtual-thread")
    @RunOnVirtualThread
    public Response getOnVirtualThread() {
        Log.warn("here is in a virtual-thread");
        var threadName = Thread.currentThread().getName();
        return Response.ok(threadName).build();
    }

    @GET
    @Path("event-loop")
    public Uni<Response> ioThread() {
        Log.warn("here is in a event-loop thread");
        return Uni.createFrom()
                .item(() -> {
                    Log.warn("here too is in event-loop thread");
                    var threadName = Thread.currentThread().getName();
                    return Response.ok(threadName).build();
                });
    }


}
