package my.study.feat.redis;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.util.UUID;

@RegisterForReflection
public class UseRedisDTO {
    private String id;
    private String name;
    private String description;

    static UseRedisDTO ofRandom() {
        final var dto = new UseRedisDTO();
        dto.setId(String.valueOf(System.currentTimeMillis()));
        dto.setName(UUID.randomUUID().toString());
        dto.setDescription(dto.getId() + ":" + dto.getName());
        return dto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
