package scooter.util;

import java.util.Random;

public class Randomizing {
    public static final String[] RAND = new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "Y", "X", "Z"
    };
    public static String getRandomizedEmail(String email){
        String [] emailArray = email.split("@");
        Random random = new Random();
        return emailArray[0] + RAND[random.nextInt(RAND.length)] + RAND[random.nextInt(RAND.length)] +
                RAND[random.nextInt(RAND.length)] + '@' + emailArray[1];
    }
}
