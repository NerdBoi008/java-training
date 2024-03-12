package intermediate.employeemanagementapp.employeemanagement;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        EmployeeManagementSystem employeeManagementSystem = new EmployeeManagementSystem(scanner);

        banner();

        while (true) {
            System.out.println("1] Add Employee \n2] Remove Employee \n3] Update Employee \n4] View Employee \n5] View All Employee \n6] Exit");
            switch (getIntegerUserInput(scanner, "Enter your choice: ")) {
                case 1:
                    employeeManagementSystem.addEmployee();
                    break;
                case 2:
                    employeeManagementSystem.removeEmployee(getIntegerUserInput(scanner, "Enter Employee Id: "));
                    break;
                case 3:
                    employeeManagementSystem.updateEmployee();
                    break;
                case 4:
                    employeeManagementSystem.viewEmployee(getIntegerUserInput(scanner, "Enter Employee Id: "));
                    break;
                case 5:
                    employeeManagementSystem.viewAllEmployee();
                    break;
                case 6:
                    return;
                default:
                    continue;
            }
        }
    }


    private static final void banner() {
        System.out.println("------------------------------------------------------------------");
        System.out.println("--------    Welcome to Employee Management System   --------------");
        System.out.println("------------------------------------------------------------------");
    }

    private static final int getIntegerUserInput(Scanner scanner, String message) {
        int value = 0;
  
        while(value == 0) {
           System.out.print(message);
  
           try {
              value = scanner.nextInt();
           } catch (InputMismatchException var4) {
              System.out.println("Invalid Input! please enter numeric value only");
              scanner.nextLine();
              value = 0;
           }
        }
  
        return value;
    }
}
