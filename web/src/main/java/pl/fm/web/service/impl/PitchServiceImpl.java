package pl.fm.web.service.impl;

import org.springframework.stereotype.Service;
import pl.fm.web.model.Pitch;

/**
 * Created by parado on 2014-11-27.
 */
@Service(PitchServiceImpl.BEAN_NAME)
public class PitchServiceImpl extends BusinessObjectServiceImpl<Pitch> {

    public static final String BEAN_NAME = "pitchService";

//    public Vector2D getCoordinatesByPosition(int position) {
//        int regionWidth = entity.getRegion().getWidth();
//        int regionHeight = entity.getRegion().getHeight();
//
//        int x = (position % PitchEntity.X_REGIONS_COUNT) * regionWidth + regionWidth / 2;
//        int y = (position / PitchEntity.X_REGIONS_COUNT) * regionHeight + regionHeight / 2;
//
//        return new Vector2D(x, y);
//    }
}