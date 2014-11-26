package pl.fm.web.model;

/**
 * Created by parado on 2014-11-25.
 */
public class Pitch {

    private int width = 800;
    private int height = 500;

    private Team hostTeam;
    private Team guestTeam;
    private Ball ball;
    private Goal hostGoal;
    private Goal guestGoal;

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
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
