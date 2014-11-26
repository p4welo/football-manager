package pl.fm.web.model;

import java.util.List;

/**
 * Created by parado on 2014-11-25.
 */
public class Team {

    private String name;
    private GoalKeeper goalKeeper;
    private List<FieldPlayer> players;

    public Team(String name) {
        this.name = name;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
