package pl.p4welo.fm.domain.match;

/**
 * Created by parado on 2015-06-18.
 */
public class Event {

    public Event(int time, boolean isHostAction, boolean isGoalScored, String messageId) {
        this.time = time;
        this.isHostAction = isHostAction;
        this.isGoalScored = isGoalScored;
        this.messageId = messageId;
    }

    private int time;
    private boolean isHostAction;
    private boolean isGoalScored;
    private String performer;
    private String messageId;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isHostAction() {
        return isHostAction;
    }

    public void setIsHostAction(boolean isHostAction) {
        this.isHostAction = isHostAction;
    }

    public boolean isGoalScored() {
        return isGoalScored;
    }

    public void setIsGoalScored(boolean isGoalScored) {
        this.isGoalScored = isGoalScored;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
