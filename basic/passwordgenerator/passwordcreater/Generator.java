package basic.passwordgenerator.passwordcreater;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class Generator {

    private final Scanner scanner;

    private boolean isUppercase;
    private boolean isLowercase;
    private boolean isNumber;
    private boolean isSymbol;
 
    public Generator(Scanner scanner) {
       this.scanner = scanner;
    }
 
    public final void mainBody() {
       System.out.println("Welcome to Zappy Password Generator.");
 
        while(true) {
            this.printMenu();
            switch (this.getUserInput()) {
                case 1:
                    this.requestPassword();
                    break;
                case 2:
                    this.passwordStrengthCheck();
                    break;
                case 3:
                    this.printUsefulInfo();
                    break;
                case 4:
                    System.out.println("Thank You for using Zappy Password Generator.");
                    return;
            }
        }
    }
 
    private final void passwordStrengthCheck() {
        int score = 0;

        boolean upperCase = false;
        boolean lowerCase = false;
        boolean numbers = false;
        boolean symbols = false;

        System.out.print("Enter your password: ");
        String input = "";

        while (input == "") {
            input = this.scanner.nextLine();
        }

        if (input.length() >= 8) {
            ++score;
        }
 
        if (input.length() >= 16) {
            ++score;
        }
 
        for (int index = 0; index < input.length(); index++) {
            char ch = input.charAt(index);

            if (upperCase && lowerCase && numbers && symbols) {
                break;
            }
 
            if (((int)ch >= 65) && ((int)ch <= 90)) {
                if (!upperCase) {
                    ++score;
                    upperCase = true;
                }
            } else if (((int)ch >= 97) && ((int)ch <= 122)) {
                if (!lowerCase) {
                    ++score;
                    lowerCase = true;
                }
            } else if (((int)ch >= 48) && ((int)ch <= 57)) {
                if (!numbers) {
                    ++score;
                    numbers = true;
                }
            } else if (!symbols) {
                ++score;
                symbols = true;
            }
       }
 
       System.out.println("---------------------------------------------------");
       Object[] var11 = new Object[]{"Upper-case", this.isUppercase};
       System.out.printf("| %-20s :     %-20s |\n", var11);
       var11 = new Object[]{"Lower-case", this.isUppercase};
       System.out.printf("| %-20s :     %-20s |\n", var11);
       var11 = new Object[]{"Numbers", this.isNumber};
       System.out.printf("| %-20s :     %-20s |\n", var11);
       var11 = new Object[]{"Symbols", this.isSymbol};
       System.out.printf("| %-20s :     %-20s |\n", var11);
       System.out.println("---------------------------------------------------");
       System.out.println("Status:");

        if (score == 6) {
            System.out.println("[+] This is password is very strong");
        } else if (score >= 4) {
            System.out.println("[+] This is a good password, but you can still do better.");
        } else if (score >= 3) {
            System.out.println("[-] This is a medium password. Try making it better.");
        } else {
            System.out.println("[-] This is weak password. You should definitely find a new one.");
        }
 
       System.out.println("---------------------------------------------------");
       System.out.println();
    }
 
    private final String generatePassword(int passwordLength) {
        String characters = (new Alphabet()).getAlphabet(this.isUppercase, this.isLowercase, this.isNumber, this.isSymbol);
        int length = characters.length();
        String password = "";
        int index = 1;
        if (index <= passwordLength) {
            while(true) {
                password = password + characters.charAt((int)(Math.random() * (double)length));
                if (index == passwordLength) {
                    break;
                }
    
                ++index;
            }
        }
    
        return password;
    }
 
    private final String requestPassword() {
        String password = "";
    
        while(true) {

            this.isUppercase = this.requestAnswer("Do you want Uppercase letter i.e. \"ABC\" to used?");
            this.isLowercase = this.requestAnswer("Do you want Lowercase letter i.e. \"abc\" to used?");
            this.isNumber = this.requestAnswer("Do you want Numbers i.e. \"0,1, ... ,9\" to used?");
            this.isSymbol = this.requestAnswer("Do you want Special characters i.e. \"(){}[].,;\" to used?");

            if (!this.isUppercase && !this.isLowercase && !this.isNumber && !this.isSymbol) { 
                System.out.println("[-] You must at least select one type to generate a password.");
                System.out.println("Let's do it again.");
            } else {
                while(true) {
                    System.out.print("Enter Length of the password to be generated: ");
                    int input = this.getUserInput();
                    if (input >= 4) {
                    password = this.generatePassword(input);
                    System.out.println("--------------------------------------------------");
                    System.out.println("Your Generated Password: " + password);
                    System.out.println("--------------------------------------------------");
                    return password;
                    }
    
                    System.out.println("Length must be at least 4 or more.");
                } 
            }
        }
    }
 
    private final void printMenu() {
        System.out.print("1] Password Generator \n2] Password Strength Checker \n3] Useful Information \n4] Quit \nEnter your choice: ");
    }
 
    private final int getUserInput() {
        int var1;
        try {
            var1 = this.scanner.nextInt();
        } catch (InputMismatchException var3) {
            System.out.println("[-] input Error: Please enter valid choice.");
            this.scanner.nextLine();
            var1 = 0;
        }
    
        return var1;
    }
 
    private final boolean requestAnswer(String msg) {
        Boolean answer = null;
        System.out.println(msg);
    
        while(true) {

            while(answer == null) {
                String input = this.scanner.nextLine();
                input = input.toLowerCase();

                
                if (input.equals("yes") || input.equals("y")) {
                    answer = true;
                    } else if (input.equals("no") || input.equals("n")) {
                        answer = false;
                    } else {
                        System.out.print("Your input must be \"Yes\" or \"No\": ");
                    continue;
                }
            }

            System.err.println("method outupt value: " + answer);
    
            return answer;
       }
    }
 
    private final void printUsefulInfo() {
        System.out.println();
        System.out.println("- Use a minimum password length of 8 or more characters if permitted.");
        System.out.println("- Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted.");
        System.out.println("- Generate passwords randomly where feasible.");
        System.out.println("- Avoid using the same password twice (e.g., across multiple user accounts and/or software systems).");
        System.out.println("- Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences,usernames, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("- Avoid using information that the user's colleagues and/or acquaintances might know to be associated with the user.");
        System.out.println("- Do not use passwords which consist wholly of any simple combination of the aforementioned weak components.");
        System.out.println();
    }
 }