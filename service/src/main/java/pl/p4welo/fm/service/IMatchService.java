package pl.p4welo.fm.service;

import pl.p4welo.fm.domain.Team;
import pl.p4welo.fm.domain.match.Simulation;

/**
 * Created by parado on 2015-06-24.
 */
public interface IMatchService {

    public Simulation simulate(Team host, Team guest);
}
