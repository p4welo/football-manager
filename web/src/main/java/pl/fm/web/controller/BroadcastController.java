package pl.fm.web.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pl.fm.web.model.Pitch;
import pl.fm.web.thread.MatchPerformer;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-11-26.
 */
@Controller
public class BroadcastController {

    @Resource
    private MatchPerformer matchPerformer;

    @MessageMapping("/fmInit")
    @SendTo("/fmInitialized")
    public Pitch initialize() {
        return matchPerformer.getPitch();
    }
}