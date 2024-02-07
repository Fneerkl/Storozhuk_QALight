package data;

import java.util.Random;

public class TestData {

    public final static String GET_RANDOM_EMAIL_UI() {
        return String.format("uvofinderr+%s@gmail.com", System.currentTimeMillis() / 1000L);
    }

    public final static String VALID_EMAIL_UI = "uvofinderr+1@gmail.com";
    public final static String VALID_PASSWORD_UI = "Uvoteam1!";

    public final static String GET_MOBILE() {
        Random rand = new Random();
        int num1 = rand.nextInt(999);
        ;
        int num2 = rand.nextInt(99);
        int num3 = rand.nextInt(99);

        return String.format("99%s%s%s", num1, num2, num3);
    }

    public final static String VALID_NAME_UI = "Olesia";
}
