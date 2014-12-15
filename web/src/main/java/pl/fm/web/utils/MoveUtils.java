package pl.fm.web.utils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * Created by parado on 2014-12-14.
 */
public class MoveUtils {

    public static LocalDateTime calculateFinishTime(int ds, int velocity) {
        return LocalDateTime.now().plus(ds / velocity, ChronoField.MILLI_OF_DAY.getBaseUnit());
    }

    public static int calculateShift(int x, int y, int futureX, int futureY) {
        double dx = futureX - x;
        double dy = futureY - y;

        double a = Math.pow(dx, 2) + Math.pow(dy, 2);

        return (int) Math.pow(a, 0.5);
    }
}
