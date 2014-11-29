package pl.fm.web.model;

/**
 * Created by parado on 2014-11-25.
 */
public class Goal implements Entity {

    private int goalsScored = 0;

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }
}
