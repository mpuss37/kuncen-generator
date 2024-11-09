package org.master;

import java.util.HashSet;
import java.util.Set;

public class PassOptions {
    PassGen passGen = new PassGen();
    String number;
    String symbol;
    String adjustCase;
    boolean choice;

    /*for can indexing args with start char '-' and if false can print error msg
    bassed on indexing args if lower on zero / 0 will print error msg*/
    public void processArgs(String[] args) {
        try {
            Set<Character> allowedChars = new HashSet<>();
            for (char c : "lnscqoeh".toCharArray()) {
                allowedChars.add(c);
            }

            /*convert array args to string*/
            String args0 = args[0];
            Character secondChar = args0.charAt(1);
            /* args zero / 0 start with char '-' */
            if (args0.startsWith("-") && allowedChars.contains(Character.toLowerCase(secondChar))) {
                handleOptions(args, args0);
            } else {
                System.out.println("kuncen-gen: missing operand\n" + "Try 'kuncen-gen -h or --help' for more information.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid arguments. Try 'kuncen-gen -h or --help' for more information.");
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Error: Invalid arguments. Try 'kuncen-gen -h or --help' for more information.");
        }
    }

    private void handleOptions(String[] args, String args0) {
        if (args0.contains("l") || args0.contains("length")) {
            handleLengthOption(args);
        }
        if (args0.contains("s") || args0.contains("symbols")) {
            handleSymbolsOption();
        }
        if (args0.contains("n") || args0.contains("number")) {
            handleNumberOption();
        }
        if (args0.contains("c") || args0.contains("case")) {
            handleAdjustCase(args);
            choice = false;
        }
        if (args0.contains("e") || args0.contains("easy")) {
            handleEasyOption();
        }
        if (args0.contains("h") || args0.contains("help")) {
            menu();
            choice = false;
        }
        if (choice) {
            for (int j = 0; j < 5; j++) {
                StringBuilder passwordLine = new StringBuilder();
                for (int i = 0; i < 5; i++) {
                    passwordLine.append(generatePassword()).append(" ");
                }
                System.out.println(passwordLine.toString().trim());
            }
        }
    }

    private void handleLengthOption(String[] args) {
        try {
            if (args.length == 2 || args.length == 3 || args.length == 4) {
                passGen.lengthPass = Integer.parseInt(args[1]);
                choice = true;
            } else {
                choice = true;
                passGen.lengthPass = 8;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid arguments. Try 'kuncen-gen -h or --help' ");
            choice = true;
            passGen.lengthPass = 8;
        }
    }

    private void handleAmountOption(String[] args) {
        try {
            if (args.length == 2 || args.length == 3 || args.length == 4) {
                passGen.Amount = Integer.parseInt(args[1]);
                choice = true;
            } else {
                choice = true;
                passGen.Amount = 5;
            }
        } catch (NumberFormatException e) {
            System.out.println("input with numeric for length.");
            choice = true;
            passGen.Amount = 5;
        }
    }

    private void handleSymbolsOption() {
        symbol = passGen.setRandomText("", "symbols", passGen.lengthPass);
        choice = true;
        if (symbol == null) {
            symbol = "";
        }
    }

    private void handleNumberOption() {
        number = passGen.setRandomText("", "number", passGen.lengthPass);
        choice = true;
        if (number == null) {
            number = "";
        }
    }

    private void handleEasyOption() {
//        passGen.setRandomTextEasy(passGen.lengthPass);
        for (int j = 0; j < 5; j++) {
            StringBuilder passwordLine = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                passwordLine.append(generatePasswordEasy()).append(" ");
            }
            System.out.println(passwordLine.toString().trim());
        }
    }

    private void handleAdjustCase(String[] args) {
        if (args.length == 2) {
            if (args[1].equals("upper") || args[1].equals("lower")) {
                adjustCase = args[1];
                choice = true;
            } else {
                adjustCase = "";
            }
        } else if (args.length == 3) {
            if (args[2].equals("upper") || args[2].equals("lower")) {
                adjustCase = args[2];
                choice = true;
            } else {
                adjustCase = "";
            }
        } else {
            // If there's no additional argument after -u
            adjustCase = "";
        }
    }


    String generatePassword() {
        if (passGen.randomText == null || passGen.randomText.isEmpty()) {
            passGen.randomText = passGen.ALPHABET + symbol + number;
        }
        passGen.finalText = passGen.setRandomText(passGen.randomText, "", passGen.lengthPass);
        passGen.choiceCase = passGen.setAdjustCase(adjustCase, passGen.finalText);
        return passGen.choiceCase;
    }

    String generatePasswordEasy() {
        passGen.finalText = passGen.setRandomTextEasy(passGen.lengthPass);
        passGen.choiceCase = passGen.setAdjustCase(adjustCase, passGen.finalText);
        return passGen.choiceCase;
    }

    public void menu() {
        System.out.println("kuncen-gen (version 1.1)");
        System.out.println("""
                Usage:
                 kuncen-gen [CUSTOM_OPTIONS]...[LENGTH]...[CASE]\t
                 Example: kuncen-gen -lcns '10' upper
                  -l, --length [values]    specified length default 8.
                  -c, --case [upper/lower]     adjust case upper or lower.
                  -n, --numeric     with numeric digits.
                  -s, --symbols [custom_char]     with symbol can add custom char.
                  -e, --easy     easy to read or write, support (Length, case).
                """);
    }
}
