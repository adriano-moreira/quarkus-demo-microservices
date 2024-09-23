package my.study.feat.u4databaseslow;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Date;

@Path("/virtual-thread/use/database-slow")
public class UseDatabaseSlowResourceVirtualThread {

    @Inject
    DbSlowRepository repository;

    @GET
    @RunOnVirtualThread
    public DbSlowDto getDBSlow() {
        var dto = new DbSlowDto();
        dto.setBefore(new Date());
        repository.run(10);
        repository.run(10);
        repository.run(10);
        repository.run(10);
        dto.setAfter(new Date());
        return dto;
    }

}
