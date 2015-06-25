package pl.p4welo.fm.domain.match;

/**
 * Created by parado on 2015-06-25.
 */
public abstract class Event {
    protected int time;
    protected EventTypeEnum type;

    public Event(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public EventTypeEnum getType() {
        return type;
    }

    public void setType(EventTypeEnum type) {
        this.type = type;
    }
}
