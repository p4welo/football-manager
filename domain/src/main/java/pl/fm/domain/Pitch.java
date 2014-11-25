package pl.fm.domain;

/**
 * Created by parado on 2014-11-25.
 */
public class Pitch {

    private Team hostTeam;
    private Team guestTeam;
    private Ball ball;
    private Goal hostGoal;
    private Goal guestGoal;



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
