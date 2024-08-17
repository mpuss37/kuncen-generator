package org.master;

import entity.User;

import java.util.Random;

public class PassGenerator {
    final String ALPHABET = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    String lengthPass;
    boolean upperCase;
    boolean lowerCase;
    boolean number;
    boolean symbols;
    boolean allChar;

    User user = new User();

    String setGenerateRandomText(int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {

            // generate random index number
            int index = random.nextInt(ALPHABET.length());

            // get character specified by index
            // from the string
            char randomChar = ALPHABET.charAt(index);

            // append the character to string builder
            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;
    }

    int setLengthPass() {
        while (true) {
            lengthPass = (user.setInput("input your length : "));
            // using regular expression for search and validate the string
            if (lengthPass.matches(".*[a-zA-Z]+.*")) {
                System.out.println("input with number.");
            } else {
                System.out.println("input valid: " + lengthPass);
                break;
            }
        }
        user.closeScanner();
        return Integer.valueOf(lengthPass);
    }

    String setUpperCase(String text) {
        if (upperCase == true) {
        }
        return text;
    }
}
