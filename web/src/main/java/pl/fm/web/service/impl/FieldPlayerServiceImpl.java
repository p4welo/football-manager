package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.FieldPlayer;
import pl.fm.web.model.MovingObject;
import pl.fm.web.service.IFieldPlayerService;
import pl.fm.web.socket.IBehaviorSocket;
import pl.fm.web.utils.Move;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-11-27.
 */

@Service(FieldPlayerServiceImpl.BEAN_NAME)
public class FieldPlayerServiceImpl extends AbstractPlayerServiceImpl<FieldPlayer> implements IFieldPlayerService {

    public static final String BEAN_NAME = "fieldPlayerService";

    @Resource
    private IBehaviorSocket behaviorSocket;

}
