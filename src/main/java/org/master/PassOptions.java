package org.master;

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
            /*convert array args to string*/
            String args0 = args[0];
            /* args zero / 0 start with char '-' */
            if (args0.startsWith("-")) {
                handleOptions(args, args0);
            } else {
                System.out.println("kuncen-gen: missing operand\n" + "Try 'kuncen-gen -h or --help' for more information.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
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
        if (args0.contains("u")) {
            handleAdjustCase(args);
        }
        if (args0.contains("h") || args0.contains("help")) {
            menu();
            choice = false;
        }
        if (choice) {
            generatePassword();
        }
    }

    private void generatePassword() {
        passGen.randomText += passGen.ALPHABET + symbol + number;
        passGen.finalText = passGen.setRandomText(passGen.randomText, "", passGen.lengthPass);
        passGen.choiceCase = passGen.setAdjustCase(adjustCase, passGen.finalText);
        System.out.println(passGen.choiceCase);
    }

    private void handleLengthOption(String[] args) {
        if (args.length == 2 || args.length == 3) {
            try {
                passGen.lengthPass = Integer.parseInt(args[1]);
                choice = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid length provided, using default length of 8.");
                choice = true;
                passGen.lengthPass = 8;
            }
        } else {
            choice = true;
            passGen.lengthPass = 8;
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
        if (number == null) {
            number = "";
        }
    }

    private void handleAdjustCase(String[] args) {
        if (args.length == 3) {
            adjustCase = args[2];
            choice = true;
        } else if (args.length == 2) {
            // If there's no additional argument after -u
            adjustCase = "";
        }
    }

    public void menu() {
        System.out.println("kuncen-gen (version 1.0, revision 1)");
        System.out.println("""
                Usage:
                 kuncen-gen [CUSTOM_OPTIONS]...[VALUES]\t
                 Example: kuncen-gen -lcns '10' upper
                  -l, --length [values]    specified length default 8.
                  -c, --case [upper/lower]     adjust case upper or lower.
                  -n, --numeric     with numeric digits.
                  -s, --symbols [custom_char]     with symbol can add custom char.
                  -e, --easy [read/write]     easy to read or write pass (soon).
                """);
    }
}
