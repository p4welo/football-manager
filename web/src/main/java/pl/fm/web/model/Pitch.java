package pl.fm.web.model;

import org.mongodb.morphia.annotations.Id;
import pl.fm.web.model.enums.PitchStateEnum;
import pl.fm.web.model.utils.Region;
import pl.fm.web.model.utils.Vector2D;

/**
 * Created by parado on 2014-11-25.
 */
@org.mongodb.morphia.annotations.Entity
public class Pitch implements Entity {

    public static final int X_REGIONS_COUNT = 6;
    public static final int Y_REGIONS_COUNT = 3;

    public static final int PITCH_WIDTH = 900;
    public static final int PITCH_HEIGHT = 450;

    @Id
    private int id;
    protected Region region;

    protected Team hostTeam;
    protected Team guestTeam;
    protected Ball ball;
    protected Goal hostGoal;
    protected Goal guestGoal;

    protected PitchStateEnum state = PitchStateEnum.WAITING;

    public PitchStateEnum getState() {
        return state;
    }

    public void setState(PitchStateEnum state) {
        this.state = state;
    }

    public Pitch() {
        region = new Region(PITCH_WIDTH / X_REGIONS_COUNT, PITCH_HEIGHT / Y_REGIONS_COUNT);
    }

    public static Vector2D getCoordinatesByPosition(int position) {
        int regionWidth = PITCH_WIDTH / X_REGIONS_COUNT;
        int regionHeight = PITCH_HEIGHT / Y_REGIONS_COUNT;

        int x = (position % X_REGIONS_COUNT) * regionWidth + regionWidth / 2;
        int y = (position / X_REGIONS_COUNT) * regionHeight + regionHeight / 2;

        return new Vector2D(x, y);
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
