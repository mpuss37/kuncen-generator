package entity;

import java.util.Scanner;

public class User {
    String firstInput;
    Scanner scanner = new Scanner(System.in);

    public String setInput(String letter){
        System.out.print(letter);
        firstInput = scanner.nextLine();
        return firstInput;
    }

    public void closeScanner(){
        scanner.close();
    }
}
