package pl.fm.web.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.fm.web.model.FieldPlayer;
import pl.fm.web.model.GoalKeeper;
import pl.fm.web.model.Team;
import pl.fm.web.model.enums.TeamStateEnum;
import pl.fm.web.service.IFieldPlayerService;
import pl.fm.web.service.ITeamService;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by parado on 2014-11-27.
 */
@Service(TeamServiceImpl.BEAN_NAME)
public class TeamServiceImpl extends BusinessObjectServiceImpl<Team> implements ITeamService {

    public static final String BEAN_NAME  = "teamService";

    @Resource
    private IFieldPlayerService fieldPlayerService;

    @Override
    public void wait(Team team) {
        team.setState(TeamStateEnum.WAITING);
    }

    @Override
    @Async
    public void think(Team team) {
        GoalKeeper goalKeeper = team.getGoalKeeper();
        List<FieldPlayer> playerList = team.getPlayers();

        for (FieldPlayer player : playerList) {
            fieldPlayerService.think(player);
        }
    }
}
