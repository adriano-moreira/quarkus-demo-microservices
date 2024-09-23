package me.study.feat.u3databasefast;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.ZonedDateTime;

@RegisterForReflection
public class DataBaseFastDTO {
    private ZonedDateTime time;
    private Integer random;

    public ZonedDateTime getTime() {
        return time;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }
}
