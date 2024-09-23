package my.study.feat.u4databaseslow;

import io.smallrye.common.annotation.RunOnVirtualThread;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.Date;

@Path("/io-thread/use/database-slow")
public class UseDatabaseSlowResourceReactive {

    @Inject
    DbSlowRepositoryReactive repositoryReactive;

    @GET
    public Uni<DbSlowDto> getDBSlow() {
        return Uni.createFrom()
                .item(() -> {
                    var dto = new DbSlowDto();
                    dto.setBefore(new Date());
                    return dto;
                })
                .call(dto -> repositoryReactive.run(10))
                .call(dto -> repositoryReactive.run(10))
                .call(dto -> repositoryReactive.run(10))
                .call(dto -> repositoryReactive.run(10))
                .invoke(dto -> dto.setAfter(new Date()));

    }

}
