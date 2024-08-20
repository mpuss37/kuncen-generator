package org.master;

import entity.User;

import java.util.Random;

public class PassGen {
    String ALPHABET = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnOoPpQqRrSsTtUuVvWwXxYyZz";
    String lengthPass;
    String randomText;
    String finalText;
    String number;
    final String symbols = "~!@#$%^&*()_+{}|:\"<>?~!@#$%^&*()_+{}|:\"<>?";
    String choice;
    User user = new User();

    String setGenRandomText(String choice, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        //adding symbols and alphabet on one variabel
        if (choice.equalsIgnoreCase("symbols")) {
            ALPHABET += symbols;
        }
        for (int i = 0; i < length; i++) {
            // generate random index number
            int index = random.nextInt(ALPHABET.length());
            // get character specified by index
            char randomChar = ALPHABET.charAt(index);
            // append the character to string builder
            sb.append(randomChar);
        }
        randomText = sb.toString();
        return randomText;
    }

    int setLengthPass() {
        while (true) {
            lengthPass = (user.setInput("input your length : "));
            // using regular expression for search and validate the string
            if (lengthPass.matches(".*[a-zA-Z]+.*")) {
                System.out.println("input with number");
            } else {
                break;
            }
        }
        return Integer.valueOf(lengthPass);
    }

    String setSymbols() {
        while (true) {
            choice = (user.setInput("symbols (Y/N) : "));
            // using regular expression for search and validate the string
            if (choice.equalsIgnoreCase("Y")) {
                break;
            } else if (choice.equalsIgnoreCase("N")) {
                break;
            } else {
                System.out.println("Input based on options (Y/N).");
            }
        }
        return choice;
    }

    String adjustCase(String options, String randomText) {
        if (options.equalsIgnoreCase("upper")) {
            finalText = setUpperCase(randomText);
        } else if (options.equalsIgnoreCase("lower")) {
            finalText = setLowerCase(randomText);
        }
        return finalText;
    }

    String setUpperCase(String randomText) {
        randomText = randomText.toUpperCase();
        return randomText;
    }

    String setLowerCase(String randomText) {
        randomText = randomText.toLowerCase();
        return randomText;
    }

//    String setUpperCase(String randomText) {
//        while (true) {
//            upperCase = user.setInput("uppercase (Y/N) : ");
//            if (upperCase.equalsIgnoreCase("Y")) {
//                randomText = randomText.toUpperCase();
//                break;
//            } else if (upperCase.equalsIgnoreCase("N")) {
//                upperCase = "";
//                break;
//            } else {
//                System.out.println("Input based on options (Y/N).");
//            }
//        }
//        return randomText;
//    }

//    String setLowerCase(String randomText) {
//        while (true) {
//            lowerCase = user.setInput("lowercase (Y/N) : ");
//            if (lowerCase.equalsIgnoreCase("Y")) {
//                randomText = randomText.toLowerCase();
//                break;
//            } else if (lowerCase.equalsIgnoreCase("N")) {
//                lowerCase = "";
//                break;
//            } else {
//                System.out.println("Input based on options (Y/N).");
//            }
//        }
//        return randomText;
//    }
}
