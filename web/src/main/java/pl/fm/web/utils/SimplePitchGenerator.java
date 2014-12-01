package pl.fm.web.utils;

import pl.fm.web.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2014-11-30.
 */
public class SimplePitchGenerator {

    public static Pitch generate() {
        int x = Pitch.PITCH_WIDTH / 2;
        int y = Pitch.PITCH_HEIGHT;

        Pitch pitch = new Pitch();

        Goal guestGoal = new Goal();
        Goal hostGoal = new Goal();

        Team guestTeam = new Team("FC Wymiatacze", "red");
        Team hostTeam = new Team("KS Kurnik", "yellow");

        pitch.setGuestGoal(guestGoal);
        pitch.setHostGoal(hostGoal);

        pitch.setGuestTeam(guestTeam);
        pitch.setHostTeam(hostTeam);

        guestTeam.setGoalKeeper(new GoalKeeper(1, x, y));
        hostTeam.setGoalKeeper(new GoalKeeper(1, x, y));

        List<FieldPlayer> guestPlayers = new ArrayList<>();
        List<FieldPlayer> hostPlayers = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            guestPlayers.add(new FieldPlayer(i + 2, x * i, y));
            hostPlayers.add(new FieldPlayer(i + 2, x * i, y));
        }

        hostTeam.setPlayers(hostPlayers);
        guestTeam.setPlayers(guestPlayers);

        return pitch;
    }
}
