package me.study.feat.u2restclient;

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
