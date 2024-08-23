package org.master;

public class Main {
    static PassOptions passOptions = new PassOptions();

    public static void main(String[] args) {
        //calling method process args for can get indexing args
        passOptions.processArgs(args);
    }
}