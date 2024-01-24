package basic.tasklistapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaskListApplication {

    public static void main(String[] args) {
        TaskList taskList = TaskList.INSTANCE;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            displayMenu();
            int choice = getUserInput(scanner);
            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    taskList.addTask(getTaskName(scanner));
                    break;
                case 2:
                    System.out.print("Enter task number to be removed: ");
                    taskList.removeTask(getUserInput(scanner));
                    break;
                case 3:
                    taskList.displayTasks();
                    break;
                case 4:
                    scanner.close();
                    System.exit(1);
                default:
                    scanner.reset();
            }
        }
    }

    
   public static final String getTaskName(Scanner scanner) {
      return scanner.next();
   }

   public static final void displayMenu() {
      System.out.print("\r \r\r\r\nTask List Application \n1. Add Task \n2. Remove Task \n3. List Tasks \n4. Quit \nSelect an option: ");
   }

   public static final int getUserInput(Scanner scanner) {
      int var1;
      try {
         var1 = scanner.nextInt();
      } catch (InputMismatchException var3) {
         System.out.println("[-] Error: Invalid input. \nPlease enter a valid integer.");
         scanner.nextLine();
         var1 = 0;
      }
      return var1;
   }
}
