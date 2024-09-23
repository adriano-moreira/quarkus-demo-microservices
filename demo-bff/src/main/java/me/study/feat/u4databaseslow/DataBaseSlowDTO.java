package me.study.feat.u4databaseslow;

import io.quarkus.runtime.annotations.RegisterForReflection;

import java.time.ZonedDateTime;
import java.util.Date;

@RegisterForReflection
public class DataBaseSlowDTO {
    private Date before;
    private Date after;

    public Date getBefore() {
        return before;
    }

    public void setBefore(Date start) {
        this.before = start;
    }

    public Date getAfter() {
        return after;
    }

    public void setAfter(Date end) {
        this.after = end;
    }
}
