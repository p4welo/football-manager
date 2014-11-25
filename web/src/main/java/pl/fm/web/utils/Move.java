package pl.fm.web.utils;

/**
 * Created by parado on 2014-11-25.
 */
public class Move {
    int id;
    int x;
    int y;
    int v;

    public Move(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }
}
