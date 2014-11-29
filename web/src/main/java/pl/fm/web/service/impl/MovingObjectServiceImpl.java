package pl.fm.web.service.impl;

import pl.fm.web.model.MovingObject;

/**
 * Created by parado on 2014-11-27.
 */
public abstract class MovingObjectServiceImpl<T extends MovingObject> extends BusinessObjectServiceImpl<T> {

    public void move(int deltaX, int deltaY, int velocity) {

    }
}
