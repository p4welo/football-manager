package pl.fm.web.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.fm.web.model.Pitch;
import pl.fm.web.model.Team;
import pl.fm.web.model.enums.TeamStateEnum;
import pl.fm.web.model.utils.Vector2D;
import pl.fm.web.service.IPitchService;
import pl.fm.web.service.ITeamService;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-11-27.
 */
@Service(PitchServiceImpl.BEAN_NAME)
public class PitchServiceImpl extends BusinessObjectServiceImpl<Pitch> implements IPitchService {

    public static final String BEAN_NAME = "pitchService";

    @Resource
    private ITeamService teamService;

    @Override
    @Async
    public void think(Pitch pitch) {

        Team guestTeam = pitch.getGuestTeam();
        Team hostTeam = pitch.getHostTeam();

//        switch (pitch.getState()) {
//            case WAITING:
//
//                if (guestTeam.getState() != TeamStateEnum.WAITING) {
//                    teamService.wait(guestTeam);
//                }
//                if (hostTeam.getState() != TeamStateEnum.WAITING) {
//                    teamService.wait(hostTeam);
//                }
//
//                break;
//
//            case INTRODUCING_PLAYERS:
//
//
//                break;
//
//            case MATCH:
//
//
//                break;
//        }

        teamService.think(guestTeam);
        teamService.think(hostTeam);
    }
}