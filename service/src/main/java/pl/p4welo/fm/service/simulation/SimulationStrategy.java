package pl.p4welo.fm.service.simulation;

import pl.p4welo.fm.domain.Team;
import pl.p4welo.fm.domain.match.*;
import pl.p4welo.fm.service.utils.RandomUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2015-06-25.
 */
public class SimulationStrategy {

    private static SimulationStrategy INSTANCE;

    private Team host;
    private Team guest;
    private boolean extraTimeAllowed = false;

    private boolean opportunity = false;
    private boolean hostAction = true;
    private int hostPossession = 0;
    private int guestPossession = 0;
    private int hostScores = 0;
    private int guestScores = 0;

    public SimulationStrategy(Team host, Team guest) {
        this.host = host;
        this.guest = guest;
    }

    public static SimulationStrategy create(Team host, Team guest) {
        return INSTANCE = new SimulationStrategy(host, guest);
    }

    public static SimulationStrategy withExtraTimeAllowed(boolean extraTimeAllowed) {
        INSTANCE.extraTimeAllowed = extraTimeAllowed;
        return INSTANCE;
    }

    public Simulation simulate() {
        Simulation simulation = new Simulation(host, guest);
        List<Event> events = new ArrayList<>();
        for (int minute = 1; minute <= 90; minute++) {
            if (opportunity) {
                // test na odebranie
                if (isTaken()) {
                    recalculatePossession(!hostAction);
                    events.add(createLoss(minute));
                    opportunity = false;
                    togglePossession();
                    continue;
                }

                // test na gola
                if (isGoal()) {
                    recalculatePossession(hostAction);
                    recalculateScores(hostAction);
                    events.add(createGoal(minute));
                    opportunity = false;
                    togglePossession();
                    continue;
                }
            } else {
                // test na opportunity
                if (isOpportunity()) {
                    calculateHolder();
                    recalculatePossession(hostAction);
                    events.add(createOpportunity(minute));
                    opportunity = true;
                    continue;
                }
            }
            // pozostałe przypadki - wylicz posiadanie
            calculateHolder();
            recalculatePossession(hostAction);
            events.add(createPossession(minute));
        }
        simulation.setEventList(events);
        return simulation;
    }

    private void calculateHolder() {
        boolean hostHolding = RandomUtil.randomInt(0, host.getPower() + guest.getPower()) <= host.getPower();
        hostAction = hostHolding;
    }

    private boolean isOpportunity() {
        return RandomUtil.randomInt(0, 100) > 80;
    }

    private Goal createGoal(int minute) {
        Goal goal = new Goal(minute);
        goal.setMessage(generateMessage("goal"));
        goal.setHostAction(hostAction);
        goal.setHostPossession(hostPossession);
        goal.setGuestPossession(guestPossession);
        goal.setHostScores(hostScores);
        goal.setGuestScores(guestScores);
        return goal;
    }

    private Action createLoss(int minute) {
        Action loss = new Action(minute);
        loss.setMessage(generateMessage("loss"));
        loss.setHostAction(hostAction);
        loss.setHostPossession(hostPossession);
        loss.setGuestPossession(guestPossession);
        return loss;
    }

    private Action createOpportunity(int minute) {
        Action opportunity = new Action(minute);
        opportunity.setMessage(generateMessage("opportunity"));
        opportunity.setHostAction(hostAction);
        opportunity.setHostPossession(hostPossession);
        opportunity.setGuestPossession(guestPossession);
        return opportunity;
    }

    private String generateMessage(String key) {
        return key + "." + RandomUtil.randomInt(0, 6);
    }

    private BallPossession createPossession(int minute) {
        BallPossession ballPossession = new BallPossession(minute);
        ballPossession.setHostPossession(hostPossession);
        ballPossession.setGuestPossession(guestPossession);
        return ballPossession;
    }

    private void togglePossession() {
        hostAction = !hostAction;
    }

    private void recalculatePossession(boolean hostAction) {
        if (hostAction) {
            hostPossession++;
        } else {
            guestPossession++;
        }
    }

    private void recalculateScores(boolean hostAction) {
        if (hostAction) {
            hostScores++;
        } else {
            guestScores++;
        }
    }

    private boolean isTaken() {
        int holder, taker;
        if (hostAction) {
            holder = host.getPower();
            taker = guest.getPower();
        } else {
            holder = guest.getPower();
            taker = host.getPower();
        }
        return RandomUtil.randomInt(0, holder + taker) <= holder;
    }

    private boolean isGoal() {

        int holder, taker;
        if (hostAction) {
            holder = host.getPower();
            taker = guest.getPower();
        } else {
            holder = guest.getPower();
            taker = host.getPower();
        }
        return RandomUtil.randomInt(0, holder + taker) <= holder;
    }
}
