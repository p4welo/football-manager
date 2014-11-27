package pl.fm.web.model;

/**
 * Created by parado on 2014-11-25.
 */
public class Ball extends MovingEntity {

    private AbstractPlayer owner;

    public AbstractPlayer getOwner() {
        return owner;
    }

    public void setOwner(AbstractPlayer owner) {
        this.owner = owner;
    }
}
