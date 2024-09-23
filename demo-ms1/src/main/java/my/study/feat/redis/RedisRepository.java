package my.study.feat.redis;

import io.quarkus.redis.datasource.RedisDataSource;
import io.quarkus.redis.datasource.value.ValueCommands;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RedisRepository {

    private final ValueCommands<String, UseRedisDTO> commands;

    public RedisRepository(RedisDataSource ds) {
        this.commands = ds.value(UseRedisDTO.class);
    }

    public void set(UseRedisDTO dto) {
        commands.set(dto.getId(), dto);
    }

    public UseRedisDTO get(String id) {
        return commands.get(id);
    }
}
