package org.master;

public class Main {
    static PassGen passGen = new PassGen();

    public static void main(String[] args) {
        if (args.length >= 1 && (args[0].equals("-l") || args[0].equals("--length"))) {
            //calling method for get specified length.
            passGen.lengthPass = String.valueOf(passGen.setLengthPass());
            //calling method for get random text.
            passGen.randomText = passGen.setGenRandomText("", Integer.parseInt(passGen.lengthPass));
            System.out.println(passGen.randomText);
        } else if (args.length >= 2 && (args[0].equals("-c") || args[0].equals("--case"))) {
            passGen.randomText = passGen.setGenRandomText("", 10);
            passGen.choice = String.valueOf(args[2]);
            passGen.finalText = passGen.adjustCase(passGen.choice, passGen.randomText);
            System.out.println(passGen.finalText);
        } else if (args.length == 1 && (args[0].equals("-h") || args[0].equals("--help"))) {
            System.out.println("kuncen-gen (version 1.0, revision 1)");
            System.out.println("""
                    Usage:
                     kuncen-gen [OPTIONS]...[VALUES]\t
                      -l, --length [values]    specified length default 8.
                      -c, --case [upper/lower]     adjust case upper or lower.
                      -n, --numeric [1..9]     with numeric digits.
                      -s, --symbols [custom_char]     with symbol can add custom char.
                      -e, --easy [read/write]     easy to read or write pass.
                    """);
        } else {
            System.out.println("kuncen-gen: missing operand\n" + "Try 'kuncen-gen -h or --help' for more information.");
        }
    }
}