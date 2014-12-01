package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.Goal;
import pl.fm.web.service.IGoalService;

/**
 * Created by parado on 2014-11-27.
 */

@Service(GoalServiceImpl.BEAN_NAME)
public class GoalServiceImpl extends BusinessObjectServiceImpl<Goal> implements IGoalService {

    public static final String BEAN_NAME = "goalService";

}
