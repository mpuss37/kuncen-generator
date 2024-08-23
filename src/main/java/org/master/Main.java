package org.master;

public class Main {
    static String number;
    static String adjustCase;
    static String symbol;
    static boolean choice;
    static String args0;
    static PassGen passGen = new PassGen();

    public static void main(String[] args) {
        try {
            args0 = args[0];
            if (args0.startsWith("-")) {
                if (args0.contains("l") || args0.contains("length")) {
                    if (args.length == 2 || args.length == 3) {
                        try {
                            passGen.lengthPass = Integer.parseInt((args[1]));
                            choice = true;
                        } catch (NumberFormatException e) {
                        }
                    } else {
                        passGen.lengthPass = 8;
                    }
                }
                if (args0.contains("s") || args0.contains("symbols")) {
                    symbol = passGen.setRandomText("", "symbols", passGen.lengthPass);
                    choice = true;
                    if (symbol.equals(null)) {
                        symbol = "";
                    }
                }
                if (args0.contains("n") || args0.contains("number")) {
                    number = passGen.setRandomText("", "number", passGen.lengthPass);
                    if (number.equals(null)) {
                        number = "";
                    }
                }
                if (args0.contains("u")) {
                    if (args.length == 3) {
                        adjustCase = String.valueOf(((args[2])));
                        choice = true;
                    } else if (args.length == 2) {
                    } else {
                        adjustCase = "";
                    }
                }
                if (args0.contains("h") || args0.contains("help")) {
                    optionsMenu();
                    choice = false;
                }
                if (choice) {
                    passGen.randomText += passGen.ALPHABET += symbol += number;
                    passGen.finalText = passGen.setRandomText(passGen.randomText, "", passGen.lengthPass);
                    passGen.choiceCase = passGen.setAdjustCase(adjustCase, passGen.finalText);
                    System.out.println(passGen.choiceCase);
                }
            } else {
                System.out.println("kuncen-gen: missing operand\n" + "Try 'kuncen-gen -h or --help' for more information.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }

    static void optionsMenu() {
        System.out.println("kuncen-gen (version 1.0, revision 1)");
        System.out.println("""
                Usage:
                 kuncen-gen [CUSTOM_OPTIONS]...[VALUES]\t
                 Example: kuncen-gen -lcns '10' upper
                  -l, --length [values]    specified length default 8.
                  -c, --case [upper/lower]     adjust case upper or lower.
                  -n, --numeric     with numeric digits.
                  -s, --symbols [custom_char]     with symbol can add custom char.
                  -e, --easy [read/write]     easy to read or write pass.
                  -h, --help     for check options and information.
                """);
    }
}