package pl.p4welo.fm.domain.match;

/**
 * Created by parado on 2015-06-25.
 */
public class Action extends BallPossession {

    protected boolean hostAction;
    protected String message;

    public Action(int time) {
        super(time);
        setType(EventTypeEnum.ACTION);
    }

    public boolean isHostAction() {
        return hostAction;
    }

    public void setHostAction(boolean hostAction) {
        this.hostAction = hostAction;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}