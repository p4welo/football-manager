package pl.p4welo.fm.service;

import pl.p4welo.fm.domain.Team;

import java.util.List;

/**
 * Created by parado on 2015-06-23.
 */
public interface ITeamService {

    public List<Team> findAll();
}
