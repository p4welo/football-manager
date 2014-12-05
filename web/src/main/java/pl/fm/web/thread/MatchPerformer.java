package pl.fm.web.thread;

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
public class MatchPerformer {

    @Resource
    private IPitchService pitchService;

    @Resource
    private IFieldPlayerService fieldPlayerService;

    private Pitch pitch;
//    private static Pitch pitch;

    private HashMap<String, FieldPlayer> playerMap;

    public MatchPerformer() {
        pitch = SimplePitchGenerator.generate();
        playerMap = new HashMap<>();
        Team team = pitch.getGuestTeam();
        for (FieldPlayer player : team.getPlayers()) {
            playerMap.put(player.getId(), player);
        }

        team = pitch.getHostTeam();
        for (FieldPlayer player : team.getPlayers()) {
            playerMap.put(player.getId(), player);
        }
    }

    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void perform() {
        pitchService.think(pitch);
    }

    public void completeMove(String playerId) {
        fieldPlayerService.wait(playerMap.get(playerId));
    }

    public Pitch getPitch() {
        return pitch;
    }

}