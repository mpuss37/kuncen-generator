package org.master;

public class Main {
    static PassGenerator passGenerator = new PassGenerator();

    static void run() {
        System.out.println(passGenerator.setGenerateRandomText(passGenerator.setLengthPass()));

    }

    public static void main(String[] args) {
        run();
    }
}