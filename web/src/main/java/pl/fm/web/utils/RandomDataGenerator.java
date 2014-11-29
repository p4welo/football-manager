package pl.fm.web.utils;

import org.springframework.context.ApplicationListener;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.broker.BrokerAvailabilityEvent;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

@Component
public class RandomDataGenerator implements ApplicationListener<BrokerAvailabilityEvent> {

    @Resource
    private MessageSendingOperations<String> messagingTemplate;

    @Override
    public void onApplicationEvent(final BrokerAvailabilityEvent event) {
    }

//    @Scheduled(fixedDelay = 2000, initialDelay = 500)
    public void sendDataUpdates0() {
        messagingTemplate.convertAndSend("/data/0", new Move(new Random().nextInt(500), new Random().nextInt(500), 5000));
    }
//
//    @Scheduled(fixedDelay = 2000, initialDelay = 100)
//    public void sendDataUpdates1() {
//        messagingTemplate.convertAndSend("/data/1", new Move(new Random().nextInt(500), new Random().nextInt(500), 5000));
//    }
//
//    @Scheduled(fixedDelay = 2000, initialDelay = 300)
//    public void sendDataUpdates2() {
//        messagingTemplate.convertAndSend("/data/2", new Move(new Random().nextInt(500), new Random().nextInt(500), 5000));
//    }
//
//    @Scheduled(fixedDelay = 2000, initialDelay = 800)
//    public void sendDataUpdates3() {
//        messagingTemplate.convertAndSend("/data/3", new Move(new Random().nextInt(500), new Random().nextInt(500), 5000));
//    }
//
//    @Scheduled(fixedDelay = 2000, initialDelay = 500)
//    public void sendDataUpdates4() {
//        messagingTemplate.convertAndSend("/data/4", new Move(new Random().nextInt(500), new Random().nextInt(500), 5000));
//    }
}