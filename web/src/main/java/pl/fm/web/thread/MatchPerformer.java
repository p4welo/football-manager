package pl.fm.web.thread;

import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.fm.web.model.Pitch;
import pl.fm.web.service.IPitchService;
import pl.fm.web.utils.SimplePitchGenerator;

import javax.annotation.Resource;

/**
 * Created by parado on 2014-11-28.
 */
@Component
@Scope("singleton")
public class MatchPerformer {

    @Resource
    private IPitchService pitchService;

    private Pitch pitch;

    public MatchPerformer() {
        pitch = SimplePitchGenerator.generate();
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void perform() {
        pitchService.think(pitch);
    }

    public Pitch getPitch() {
        return pitch;
    }
}