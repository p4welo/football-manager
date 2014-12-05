package pl.fm.web.socket.impl;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.stereotype.Service;
import pl.fm.web.model.FieldPlayer;
import pl.fm.web.socket.IBehaviorSocket;
import pl.fm.web.utils.Move;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-11-29.
 */
@Service(BehaviorSocketImpl.BEAN_NAME)
public class BehaviorSocketImpl implements IBehaviorSocket, ApplicationListener<BrokerAvailabilityEvent> {

    public static final String BEAN_NAME = "behaviorSocket";

    @Resource
    private MessageSendingOperations<String> messagingTemplate;

    @Override
    public void move(FieldPlayer player, int x, int y) {
        messagingTemplate.convertAndSend("/fmMove", new Move(player.getId(), x, y, 50));
    }

    @Override
    public void onApplicationEvent(BrokerAvailabilityEvent brokerAvailabilityEvent) {
    }
}
