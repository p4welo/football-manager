package pl.fm.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @RequestMapping(value = "player/{id}/move/complete", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void onMoveComplete(@PathVariable("id") String id) {
        matchPerformer.completeMove(id);
    }
}