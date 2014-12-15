package pl.fm.web.service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import pl.fm.web.model.FieldPlayer;
import pl.fm.web.model.enums.PlayerStateEnum;
import pl.fm.web.service.IFieldPlayerService;
import pl.fm.web.socket.IBehaviorSocket;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

/**
 * Created by parado on 2014-11-27.
 */

@Service(FieldPlayerServiceImpl.BEAN_NAME)
public class FieldPlayerServiceImpl extends AbstractPlayerServiceImpl<FieldPlayer> implements IFieldPlayerService {

    public static final String BEAN_NAME = "fieldPlayerService";

    @Resource
    private IBehaviorSocket behaviorSocket;

    @Override
    @Async
    public void think(FieldPlayer player) {
        System.out.println(new Date().getTime() + "Player thinking: " + player.getId());
        if (player.getState() == PlayerStateEnum.IN_MOVE && LocalDateTime.now().isAfter(player.getFinishMoveTime())) {
            player.setX(player.getFutureX());
            player.setY(player.getFutureY());
            player.setFinishMoveTime(null);
            player.setState(PlayerStateEnum.WAITING);
        }

        if (player.getState() != PlayerStateEnum.IN_MOVE) {
            player.setState(PlayerStateEnum.IN_MOVE);

            int x = (new Random()).nextInt(880) + 10;
            int y = (new Random()).nextInt(430) + 10;
            player.setFutureX(x);
            player.setFutureY(y);
            player.setVelocity(50);
            behaviorSocket.move(player);
        }
    }

    @Override
    @Async
    public void wait(FieldPlayer player) {
        player.setState(PlayerStateEnum.WAITING);
    }
}
