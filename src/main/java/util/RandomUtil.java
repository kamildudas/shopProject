package util;

import java.util.Random;

public class RandomUtil {
    private Random random = new Random();
    private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String randomizeString(final int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be a positive");
        }

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

}
