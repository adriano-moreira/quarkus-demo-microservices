package my.study.feat.random;

import java.time.ZonedDateTime;

public class RandomDTO {
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
