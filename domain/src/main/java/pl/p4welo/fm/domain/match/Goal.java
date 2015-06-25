package pl.p4welo.fm.domain.match;

/**
 * Created by parado on 2015-06-25.
 */
public class Goal extends Action {

    protected int hostScores;
    protected int guestScores;

    public Goal(int time) {
        super(time);
        setType(EventTypeEnum.GOAL);
    }

    public int getHostScores() {
        return hostScores;
    }

    public void setHostScores(int hostScores) {
        this.hostScores = hostScores;
    }

    public int getGuestScores() {
        return guestScores;
    }

    public void setGuestScores(int guestScores) {
        this.guestScores = guestScores;
    }
}