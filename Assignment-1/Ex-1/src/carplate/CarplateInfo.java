package carplate;

import java.util.Random;

public final class CarplateInfo {

    static final String LETTERS_AVAILABLE = "ABCDEFGHIJKLMNPQRSTUVWXYZ";
    static final String NUMBERS_AVAILABLE = "023456789";

    public static String randomPlate() {
        Random random = new Random();
        StringBuilder plate= new StringBuilder();

        for (int i=0; i < 2; i++) {
            plate.append(LETTERS_AVAILABLE.charAt(random.nextInt(LETTERS_AVAILABLE.length())));
        }

        for (int i=0; i < 3; i++) {
            plate.append(NUMBERS_AVAILABLE.charAt(random.nextInt(NUMBERS_AVAILABLE.length())));
        }

        for (int i=0; i < 2; i++) {
            if (random.nextBoolean()) {
                plate.append(NUMBERS_AVAILABLE.charAt(random.nextInt(NUMBERS_AVAILABLE.length())));
            }
            else {
                plate.append(LETTERS_AVAILABLE.charAt(random.nextInt(LETTERS_AVAILABLE.length())));
            }
        }

        return plate.toString();
    }



    public static boolean plateValidity(String plate) {
        if (plate == null || plate.length() != 7) {
            return true;
        }

        for (int i = 0; i < 2; i++) {
            if (!LETTERS_AVAILABLE.contains(String.valueOf(plate.charAt(i)))) {
                return true;
            }
        }

        for (int i = 2; i < 5; i++) {
            if (!NUMBERS_AVAILABLE.contains(String.valueOf(plate.charAt(i)))) {
                return true;
            }
        }

        for (int i = 5; i < 7; i++) {
            char c = plate.charAt(i);
            if (!LETTERS_AVAILABLE.contains(String.valueOf(c)) && !NUMBERS_AVAILABLE.contains(String.valueOf(c))) {
                return true;
            }
        }

        return false;
    }



    public static String nextPlate(String randomPlate) {
        char[] plateChars = randomPlate.toCharArray();

        for (int i = plateChars.length - 1; i >= 0; i--) {
            if (NUMBERS_AVAILABLE.contains(String.valueOf(plateChars[i]))) {
                int currentIndex = NUMBERS_AVAILABLE.indexOf(plateChars[i]);
                if (currentIndex < NUMBERS_AVAILABLE.length() - 1) {
                    plateChars[i] = NUMBERS_AVAILABLE.charAt(currentIndex + 1);
                    return new String(plateChars);
                }
                plateChars[i] = NUMBERS_AVAILABLE.charAt(0);
            } else if (LETTERS_AVAILABLE.contains(String.valueOf(plateChars[i]))) {
                int currentIndex = LETTERS_AVAILABLE.indexOf(plateChars[i]);
                if (currentIndex < LETTERS_AVAILABLE.length() - 1) {
                    plateChars[i] = LETTERS_AVAILABLE.charAt(currentIndex + 1);
                    return new String(plateChars);
                }
                plateChars[i] = LETTERS_AVAILABLE.charAt(0);
            }
        }
        return "No next plate number exists.";
    }

}