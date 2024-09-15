package my.study.feat.dbslow;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Date;

@Path( "/db-slow")
public class DBSlowResource {

    @Inject
    DbSlowRepository repository;

    @GET
    public DbSlowDto getDBSlow() {

        //exec 2 queries

        //query 1
        Date before = repository.run(50).getBefore();
        //query 2
        Date after = repository.run(50).getAfter();

        var dto = new DbSlowDto();
        dto.setBefore(before);
        dto.setAfter(after);
        return dto;

    }

}
