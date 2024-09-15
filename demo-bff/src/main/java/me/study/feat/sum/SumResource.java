package me.study.feat.sum;

import io.opentelemetry.instrumentation.annotations.WithSpan;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/sum")
public class SumResource {

    @Inject
    SumService sumService;

    @GET
    @Path("/{a}/{b}")
    @WithSpan
    public String sum(Integer a, Integer b) {
        return sumService.sum(a, b).toString();
    }

}
