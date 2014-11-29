package pl.fm.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.fm.web.model.Pitch;

/**
 * Created by parado on 2014-11-26.
 */
@Controller
public class BroadcastController {


    @MessageMapping("/fmInit")
    @SendTo("/fmInitialized")
    public Pitch initialize() {
        return null;
//        return applicationService.initializePitch();
    }
}