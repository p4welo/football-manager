package pl.p4welo.fm.service.impl;

import org.springframework.stereotype.Service;
import pl.p4welo.fm.domain.Team;
import pl.p4welo.fm.domain.match.Simulation;
import pl.p4welo.fm.service.IMatchService;
import pl.p4welo.fm.service.simulation.SimulationStrategy;

/**
 * Created by parado on 2015-06-24.
 */
@Service
public class MatchServiceImpl implements IMatchService {

    @Override
    public Simulation simulate(Team host, Team guest) {

        Simulation simulation = SimulationStrategy.create(host, guest)
                .withExtraTimeAllowed(false)
                .simulate();
        return simulation;
    }
}
