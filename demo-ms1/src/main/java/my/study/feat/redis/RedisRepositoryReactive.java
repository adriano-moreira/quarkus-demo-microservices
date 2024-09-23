package my.study.feat.redis;

import io.quarkus.redis.datasource.ReactiveRedisDataSource;
import io.quarkus.redis.datasource.value.ReactiveValueCommands;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RedisRepositoryReactive {

    private final ReactiveValueCommands<String, UseRedisDTO> reactiveCommands;

    public RedisRepositoryReactive(ReactiveRedisDataSource dsReactive) {
        this.reactiveCommands = dsReactive.value(UseRedisDTO.class);
    }

    public Uni<Void> set(UseRedisDTO dto) {
        return reactiveCommands.set(dto.getId(), dto);
    }

    public Uni<UseRedisDTO> get(String id) {
        return reactiveCommands.get(id);
    }
}
