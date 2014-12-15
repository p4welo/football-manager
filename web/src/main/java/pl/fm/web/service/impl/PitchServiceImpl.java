package pl.fm.web.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.fm.web.dao.IPitchDao;
import pl.fm.web.model.Pitch;
import pl.fm.web.model.Team;
import pl.fm.web.model.enums.PitchStateEnum;
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

    @Resource
    private IPitchDao pitchDao;

    @Override
    @Async
    public void think(Pitch pitch) {

        Team guestTeam = pitch.getGuestTeam();
        Team hostTeam = pitch.getHostTeam();

        if (pitch.getState() == PitchStateEnum.MATCH) {
            teamService.think(guestTeam);
            teamService.think(hostTeam);
        }

        pitchDao.update(pitch);
    }

    @Override
    @Async
    public void start(Pitch pitch) {
        pitch.setState(PitchStateEnum.MATCH);
        pitchDao.update(pitch);
    }

    @Override
    public void save(Pitch pitch) {
        pitchDao.save(pitch);
    }

    @Override
    public Pitch getPitch() {
        return pitchDao.get();
    }
}