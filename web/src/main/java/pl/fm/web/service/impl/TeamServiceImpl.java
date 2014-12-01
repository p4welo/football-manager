package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.Team;
import pl.fm.web.model.enums.TeamStateEnum;
import pl.fm.web.service.ITeamService;

/**
 * Created by parado on 2014-11-27.
 */
@Service(TeamServiceImpl.BEAN_NAME)
public class TeamServiceImpl extends BusinessObjectServiceImpl<Team> implements ITeamService {

    public static final String BEAN_NAME  = "teamService";

    @Override
    public void wait(Team team) {
        team.setState(TeamStateEnum.WAITING);
    }
}
