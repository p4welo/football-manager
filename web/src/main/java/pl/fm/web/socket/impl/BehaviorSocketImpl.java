package pl.fm.web.socket.impl;

import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.stereotype.Service;
import pl.fm.web.socket.IBehaviorSocket;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-11-29.
 */
@Service(BehaviorSocketImpl.BEAN_NAME)
public class BehaviorSocketImpl implements IBehaviorSocket {

    public static final String BEAN_NAME = "behaviorSocket";

    @Resource
    private MessageSendingOperations<String> messagingTemplate;

}
