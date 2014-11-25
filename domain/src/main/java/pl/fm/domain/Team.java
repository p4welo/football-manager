package pl.fm.domain;

import java.util.List;

/**
 * Created by parado on 2014-11-25.
 */
public class Team {

    private GoalKeeper goalKeeper;
    private List<FieldPlayer> players;

    public GoalKeeper getGoalKeeper() {
        return goalKeeper;
    }

    public void setGoalKeeper(GoalKeeper goalKeeper) {
        this.goalKeeper = goalKeeper;
    }

    public List<FieldPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<FieldPlayer> players) {
        this.players = players;
    }
}
