package pl.p4welo.fm.service.utils;

import java.util.Random;

/**
 * Created by parado on 2015-06-24.
 */
public class RandomUtil {

    public static int randomInt(int start, int end) {
        Random generator = new Random();
        return generator.nextInt(end) + start;
    }
}
