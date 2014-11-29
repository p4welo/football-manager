package pl.fm.web.model.utils;

/**
 * Created by parado on 2014-11-27.
 */
public class Region {
    private int width;
    private int height;

    public Region() {
        this(0, 0);
    }

    public Region(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
