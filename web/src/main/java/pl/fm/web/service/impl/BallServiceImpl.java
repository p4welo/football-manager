package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.Ball;
import pl.fm.web.model.utils.Vector2D;
import pl.fm.web.service.IBallService;

/**
 * Created by parado on 2014-11-27.
 */
@Service(BallServiceImpl.BEAN_NAME)
public class BallServiceImpl extends MovingObjectServiceImpl<Ball> implements IBallService {

    public static final String BEAN_NAME = "ballService";

    public void kick(Vector2D vector, double force) {

    }
}
