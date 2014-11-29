package pl.fm.web.model;

/**
 * Created by parado on 2014-11-25.
 */
public abstract class MovingObject implements Entity {

    private int id;
    private int x;
    private int y;

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

}
