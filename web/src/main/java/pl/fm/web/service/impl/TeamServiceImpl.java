package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.Team;

/**
 * Created by parado on 2014-11-27.
 */
@Service(TeamServiceImpl.BEAN_NAME)
public class TeamServiceImpl extends BusinessObjectServiceImpl<Team> {

    public static final String BEAN_NAME  = "teamService";

}
