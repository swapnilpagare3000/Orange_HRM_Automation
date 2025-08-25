package utils;

import java.util.Random;

public class RandomNameGenerator {
    private static final String[] FIRST_NAMES = {
        "John", "Jane", "Alex", "Emily", "Chris", "Katie", "Michael", "Sarah", "David", "Laura"
    };
    private static final String[] LAST_NAMES = {
        "Smith", "Johnson", "Williams", "Brown", "Jones", "Garcia", "Miller", "Davis", "Martinez", "Taylor"
    };
    private static final Random random = new Random();

    public static String getRandomFirstName() {
        return FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
    }

    public static String getRandomLastName() {
        return LAST_NAMES[random.nextInt(LAST_NAMES.length)];
    }

    public static String getRandomFullName() {
        return getRandomFirstName() + " " + getRandomLastName();
    }
}
