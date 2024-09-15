package my.study.feat.dbslow;

import java.util.Date;

public class DbSlowDto {
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
