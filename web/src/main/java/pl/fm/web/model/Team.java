package pl.fm.web.model;

import pl.fm.web.service.impl.FieldPlayerServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2014-11-25.
 */
public class Team implements Entity {

    private String name;
    private GoalKeeper goalKeeper;
    private List<FieldPlayer> players;

    private FieldPlayerServiceImpl controllingPlayer;
    private FieldPlayerServiceImpl supportingPlayer;
    private FieldPlayerServiceImpl receivingPlayer;
    private FieldPlayerServiceImpl closestToBallPlayer;

    public Team(String name) {
        this.name = name;
        players = new ArrayList<>();
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

    public FieldPlayerServiceImpl getControllingPlayer() {
        return controllingPlayer;
    }

    public void setControllingPlayer(FieldPlayerServiceImpl controllingPlayer) {
        this.controllingPlayer = controllingPlayer;
    }

    public FieldPlayerServiceImpl getSupportingPlayer() {
        return supportingPlayer;
    }

    public void setSupportingPlayer(FieldPlayerServiceImpl supportingPlayer) {
        this.supportingPlayer = supportingPlayer;
    }

    public FieldPlayerServiceImpl getReceivingPlayer() {
        return receivingPlayer;
    }

    public void setReceivingPlayer(FieldPlayerServiceImpl receivingPlayer) {
        this.receivingPlayer = receivingPlayer;
    }

    public FieldPlayerServiceImpl getClosestToBallPlayer() {
        return closestToBallPlayer;
    }

    public void setClosestToBallPlayer(FieldPlayerServiceImpl closestToBallPlayer) {
        this.closestToBallPlayer = closestToBallPlayer;
    }
}
