package basic.passwordgenerator.passwordcreater;

import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Generator generator = new Generator(scanner);
        generator.mainBody();
        scanner.close();
    }
}