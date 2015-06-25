package pl.p4welo.fm.domain.match;

/**
 * Created by parado on 2015-06-25.
 */
public class BallPossession extends Event {

    protected int hostPossession;
    protected int guestPossession;

    public BallPossession(int time) {
        super(time);
        setType(EventTypeEnum.BALL_POSSESSION);
    }

    public int getHostPossession() {
        return hostPossession;
    }

    public void setHostPossession(int hostPossession) {
        this.hostPossession = hostPossession;
    }

    public int getGuestPossession() {
        return guestPossession;
    }

    public void setGuestPossession(int guestPossession) {
        this.guestPossession = guestPossession;
    }
}