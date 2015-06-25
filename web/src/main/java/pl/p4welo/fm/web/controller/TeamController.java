package pl.p4welo.fm.web.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.p4welo.fm.domain.Team;
import pl.p4welo.fm.domain.match.Simulation;
import pl.p4welo.fm.service.IMatchService;
import pl.p4welo.fm.service.ITeamService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2015-06-23.
 */
@RestController
@RequestMapping(value = "/team")
public class TeamController {

    @Resource
    private ITeamService teamService;

    @Resource
    private IMatchService matchService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List getTeams() {
        return teamService.findAll();
    }

    @RequestMapping(value = "/{hostId}/{guestId}/simulate", method = RequestMethod.GET)
    public Simulation simulate(@PathVariable int hostId, @PathVariable int guestId) {
        Team hostTeam = teamService.getById(hostId);
        Team guestTeam = teamService.getById(guestId);

        return matchService.simulate(hostTeam, guestTeam);
    }
}
