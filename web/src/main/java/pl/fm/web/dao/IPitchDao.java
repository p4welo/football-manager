package pl.fm.web.dao;

import pl.fm.web.model.Pitch;

/**
 * Created by parado on 2014-12-14.
 */
public interface IPitchDao {
    Pitch get();

    org.mongodb.morphia.Key<Pitch> save(Pitch pitch);

    void update(Pitch pitch);
}
