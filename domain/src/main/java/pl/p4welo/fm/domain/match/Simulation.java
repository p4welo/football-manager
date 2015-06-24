package pl.p4welo.fm.domain.match;

import pl.p4welo.fm.domain.Team;

import java.util.List;

/**
 * Created by parado on 2015-06-18.
 */
public class Simulation {
    private Team hostTeam;
    private Team guestTeam;
    private List<Event> eventList;

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

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }
}
