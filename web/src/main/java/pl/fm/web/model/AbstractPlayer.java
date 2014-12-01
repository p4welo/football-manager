package pl.fm.web.model;

/**
 * Created by parado on 2014-11-25.
 */
public abstract class AbstractPlayer extends MovingObject {
    protected AbstractPlayer() {
        super();
    }

    protected int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
