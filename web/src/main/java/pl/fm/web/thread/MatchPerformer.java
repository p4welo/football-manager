package pl.fm.web.thread;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.fm.web.model.AbstractPlayer;
import pl.fm.web.model.FieldPlayer;
import pl.fm.web.model.Pitch;
import pl.fm.web.model.Team;
import pl.fm.web.service.IAbstractPlayerService;
import pl.fm.web.service.IFieldPlayerService;
import pl.fm.web.service.IPitchService;
import pl.fm.web.utils.SimplePitchGenerator;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by parado on 2014-11-28.
 */
@Component
@Scope("singleton")
public class MatchPerformer implements InitializingBean {

    @Resource
    private IPitchService pitchService;

    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void perform() {
        Pitch pitch = pitchService.getPitch();
        pitchService.think(pitch);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
//        Pitch pitch = SimplePitchGenerator.generate();
//        pitchService.save(pitch);
    }
}