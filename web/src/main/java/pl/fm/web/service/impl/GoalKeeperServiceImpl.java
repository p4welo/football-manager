package pl.fm.web.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.fm.web.model.GoalKeeper;
import pl.fm.web.service.IGoalKeeperService;

/**
 * Created by parado on 2014-11-27.
 */

@Service(GoalKeeperServiceImpl.BEAN_NAME)
public class GoalKeeperServiceImpl extends AbstractPlayerServiceImpl<GoalKeeper> implements IGoalKeeperService {

    public static final String BEAN_NAME = "goalKeeperService";


    @Override
    @Async
    public void think(GoalKeeper goalKeeper) {

    }
}
