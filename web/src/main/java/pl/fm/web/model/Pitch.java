package pl.fm.web.model;

import pl.fm.web.model.utils.Region;

/**
 * Created by parado on 2014-11-25.
 */
public class Pitch implements Entity {

    public static final int X_REGIONS_COUNT = 6;
    public static final int Y_REGIONS_COUNT = 3;

    public static final int PITCH_WIDTH = 900;
    public static final int PITCH_HEIGHT = 450;

    private Region region;

    private Team hostTeam;
    private Team guestTeam;
    private Ball ball;
    private Goal hostGoal;
    private Goal guestGoal;

    public Pitch() {
        region = new Region(PITCH_WIDTH / X_REGIONS_COUNT, PITCH_HEIGHT / Y_REGIONS_COUNT);
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Team getHostTeam() {
        return hostTeam;
    }

    public void setHostTeam(Team hostTeam) {
        this.hostTeam = hostTeam;
    }

    public Team getGuestTeam() {
        return guestTeam;
    }

    public void setGuestTeam(Team guestTeam) {
        this.guestTeam = guestTeam;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Goal getHostGoal() {
        return hostGoal;
    }

    public void setHostGoal(Goal hostGoal) {
        this.hostGoal = hostGoal;
    }

    public Goal getGuestGoal() {
        return guestGoal;
    }

    public void setGuestGoal(Goal guestGoal) {
        this.guestGoal = guestGoal;
    }
}
