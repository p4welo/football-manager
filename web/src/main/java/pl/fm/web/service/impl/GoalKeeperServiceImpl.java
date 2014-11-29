package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.GoalKeeper;

/**
 * Created by parado on 2014-11-27.
 */

@Service(GoalKeeperServiceImpl.BEAN_NAME)
public class GoalKeeperServiceImpl extends AbstractPlayerServiceImpl<GoalKeeper> {

    public static final String BEAN_NAME = "goalKeeperService";


}
