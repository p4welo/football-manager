package pl.fm.web.utils;

import pl.fm.web.model.Goal;
import pl.fm.web.model.Pitch;
import pl.fm.web.model.Team;

/**
 * Created by parado on 2014-11-30.
 */
public class SimplePitchGenerator {

    public static Pitch generate() {

        Pitch pitch = new Pitch();

        Goal guestGoal = new Goal();
        Goal hostGoal = new Goal();

        Team guestTeam = new Team("FC Wymiatacze");
        Team hostTeam = new Team("KS Kurnik");

        pitch.setGuestGoal(guestGoal);
        pitch.setHostGoal(hostGoal);

        pitch.setGuestTeam(guestTeam);
        pitch.setHostTeam(hostTeam);

        return pitch;
    }
}
