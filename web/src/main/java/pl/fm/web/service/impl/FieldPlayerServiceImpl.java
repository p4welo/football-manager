package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.FieldPlayer;

/**
 * Created by parado on 2014-11-27.
 */

@Service(FieldPlayerServiceImpl.BEAN_NAME)
public class FieldPlayerServiceImpl extends AbstractPlayerServiceImpl<FieldPlayer> {

    public static final String BEAN_NAME = "fieldPlayerService";


}
