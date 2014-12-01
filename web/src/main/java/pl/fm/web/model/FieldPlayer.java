package pl.fm.web.model;

import pl.fm.web.model.enums.PlayerStateEnum;

/**
 * Created by parado on 2014-11-25.
 */
public class FieldPlayer extends AbstractPlayer {

    public FieldPlayer(int number, int x, int y) {
        super();
        this.number = number;
        this.x = x;
        this.y = y;
    }

    protected PlayerStateEnum state;

    public FieldPlayer(int number) {
        this.number = number;
    }

    public PlayerStateEnum getState() {
        return state;
    }

    public void setState(PlayerStateEnum state) {
        this.state = state;
    }
}
