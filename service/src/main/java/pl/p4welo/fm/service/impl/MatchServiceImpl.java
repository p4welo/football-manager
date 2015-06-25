package pl.p4welo.fm.service.impl;

import org.springframework.stereotype.Service;
import pl.p4welo.fm.domain.Team;
import pl.p4welo.fm.domain.match.Event;
import pl.p4welo.fm.domain.match.Simulation;
import pl.p4welo.fm.service.IMatchService;
import pl.p4welo.fm.service.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2015-06-24.
 */
@Service
public class MatchServiceImpl implements IMatchService {

    @Override
    public Simulation simulate(Team host, Team guest) {
        Simulation result = new Simulation(host, guest);
        result.setHostTeam(host);
        result.setGuestTeam(guest);
        List<Event> eventList = new ArrayList<>();
        for (int minute = 1; minute <= 90; minute++) {
            eventList.add(generateEvent(minute, host, guest));
        }
        result.setEventList(eventList);
        return result;
    }

    private Event generateEvent(int minute, Team host, Team guest) {
        boolean isHostPossession = isHostPossession(host, guest);
        Event result = new Event(minute, isHostPossession);
        boolean isScoringOpportunity = isScoringOpportunity(isHostPossession ? host.getPower() : guest.getPower());
        result.setIsScoringOpportunity(isScoringOpportunity);
        if (isScoringOpportunity) {
            boolean isGoalScored = isGoalScored(isHostPossession ? host.getPower() : guest.getPower());
            result.setIsGoalScored(isGoalScored);
        }
        return result;
    }

    private boolean isScoringOpportunity(double power) {
        return RandomUtil.randomInt(0, 100) > 80;
    }

    private boolean isGoalScored(double power) {
        int diff = 100 - new Double(power).intValue();
        return RandomUtil.randomInt(0, 100) > diff + 20;
    }

    private boolean isHostPossession(Team host, Team guest) {
        int hostPower = new Double(host.getPower()).intValue();
        int guestPower = new Double(guest.getPower()).intValue();

        return RandomUtil.randomInt(0, hostPower + guestPower) <= hostPower;
    }
}
