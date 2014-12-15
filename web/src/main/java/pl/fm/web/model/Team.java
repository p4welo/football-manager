package pl.fm.web.model;

import pl.fm.web.model.enums.TeamStateEnum;
import pl.fm.web.service.impl.FieldPlayerServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2014-11-25.
 */
public class Team implements Entity {

    protected String name;
    protected String color;
    protected GoalKeeper goalKeeper;
    protected List<FieldPlayer> players;

    protected FieldPlayerServiceImpl controllingPlayer;
    protected FieldPlayerServiceImpl supportingPlayer;
    protected FieldPlayerServiceImpl receivingPlayer;
    protected FieldPlayerServiceImpl closestToBallPlayer;

    protected TeamStateEnum state;

    public Team() {
    }

    public Team(String name, String color) {
        this.name = name;
        this.color = color;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TeamStateEnum getState() {
        return state;
    }

    public void setState(TeamStateEnum state) {
        this.state = state;
    }
}
