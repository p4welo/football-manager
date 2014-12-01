package pl.fm.web.service.impl;

import pl.fm.web.model.AbstractPlayer;
import pl.fm.web.service.IAbstractPlayerService;

/**
 * Created by parado on 2014-11-27.
 */
public abstract class AbstractPlayerServiceImpl<T extends AbstractPlayer> extends MovingObjectServiceImpl<T> implements IAbstractPlayerService {
}
