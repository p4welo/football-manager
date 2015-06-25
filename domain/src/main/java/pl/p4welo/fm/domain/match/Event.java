package pl.p4welo.fm.domain.match;

/**
 * Created by parado on 2015-06-18.
 */
public class Event {


    private int time;
    private boolean hostPossession;
    private boolean scoringOpportunity;
    private boolean goalScored;
    private String performer;
    private String messageId;

    public Event(int time, boolean hostPossession) {
        this.time = time;
        this.hostPossession = hostPossession;
    }

    public Event(int time, boolean hostPossession, boolean goalScored) {
        this.time = time;
        this.hostPossession = hostPossession;
        this.goalScored = goalScored;
    }

    public boolean isScoringOpportunity() {
        return scoringOpportunity;
    }

    public void setIsScoringOpportunity(boolean isScoringOpportunity) {
        this.scoringOpportunity = isScoringOpportunity;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean isHostPossession() {
        return hostPossession;
    }

    public void setIsHostPossession(boolean isHostPossession) {
        this.hostPossession = isHostPossession;
    }

    public boolean isGoalScored() {
        return goalScored;
    }

    public void setIsGoalScored(boolean isGoalScored) {
        this.goalScored = isGoalScored;
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
