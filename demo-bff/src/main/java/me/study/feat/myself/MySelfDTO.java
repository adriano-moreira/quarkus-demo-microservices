package me.study.feat.myself;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class MySelfDTO {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
