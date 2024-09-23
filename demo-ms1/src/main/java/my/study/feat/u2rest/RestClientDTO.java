package my.study.feat.u2rest;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class RestClientDTO {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
