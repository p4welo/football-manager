package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.*;
import pl.fm.web.service.IApplicationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2014-11-27.
 */
@Service(value = ApplicationServiceImpl.BEAN_NAME)
public class ApplicationServiceImpl implements IApplicationService {

    public static final String BEAN_NAME = "applicationService";

    @Override
    public Pitch initializePitch() {

        Pitch pitch = new Pitch();

        Ball ball = new Ball();
        pitch.setBall(ball);

        Team guestTeam = new Team("FC Wymiatacze");
        Team hostTeam = new Team("Przystankersi");

        pitch.setGuestTeam(guestTeam);
        pitch.setHostTeam(hostTeam);

        guestTeam.setGoalKeeper(new GoalKeeper());
        hostTeam.setGoalKeeper(new GoalKeeper());

        List<FieldPlayer> guestPlayers = new ArrayList<>();
        List<FieldPlayer> hostPlayers = new ArrayList<>();
        for (int i=0; i<4; i++) {
            guestPlayers.add(new FieldPlayer());
            hostPlayers.add(new FieldPlayer());
        }

        return pitch;
    }
}
