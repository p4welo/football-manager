package pl.fm.web.model;

import pl.fm.web.utils.SidUtils;

import java.time.LocalDateTime;

/**
 * Created by parado on 2014-11-25.
 */
public abstract class MovingObject implements Entity {

    protected MovingObject() {
        this.id = SidUtils.generate();
    }

    protected String id;
    protected int x = 0;
    protected int y = 0;
    protected int velocity;
    protected int futureX;
    protected int futureY;
    protected LocalDateTime finishMoveTime;

    public LocalDateTime getFinishMoveTime() {
        return finishMoveTime;
    }

    public void setFinishMoveTime(LocalDateTime finishMoveTime) {
        this.finishMoveTime = finishMoveTime;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getFutureX() {
        return futureX;
    }

    public void setFutureX(int futureX) {
        this.futureX = futureX;
    }

    public int getFutureY() {
        return futureY;
    }

    public void setFutureY(int futureY) {
        this.futureY = futureY;
    }
}
