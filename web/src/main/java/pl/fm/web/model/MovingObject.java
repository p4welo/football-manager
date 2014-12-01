package pl.fm.web.model;

import pl.fm.web.utils.SidUtils;

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
}
