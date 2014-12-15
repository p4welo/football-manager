package pl.fm.web.dao.impl;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Key;
import org.mongodb.morphia.Morphia;
import org.springframework.stereotype.Repository;
import pl.fm.web.dao.IPitchDao;
import pl.fm.web.model.Pitch;

import java.net.UnknownHostException;

/**
 * Created by parado on 2014-12-14.
 */
@Repository(PitchDaoImpl.BEAN_NAME)
public class PitchDaoImpl implements IPitchDao {

    public static final String BEAN_NAME = "pitchDao";

    private Datastore ds;

    public PitchDaoImpl() throws UnknownHostException {
        MongoClient mongo = new MongoClient(new ServerAddress("localhost", 27017));
        Morphia morphia = new Morphia();
        morphia.map(Pitch.class);
        ds = morphia.createDatastore(mongo, "fmdb");
    }

    @Override
    public Pitch get() {
        return ds.find(Pitch.class).get();
    }

    @Override
    public Key<Pitch> save(Pitch pitch) {
        return ds.save(pitch);
    }

    @Override
    public void update(Pitch pitch) {
        ds.update(pitch, ds.createUpdateOperations(Pitch.class));
    }
}