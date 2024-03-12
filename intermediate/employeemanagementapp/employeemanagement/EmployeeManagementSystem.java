package intermediate.employeemanagementapp.employeemanagement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public final class EmployeeManagementSystem {

   private final Scanner scanner;
   private final Set<Employee> employeeSet;
 
   public EmployeeManagementSystem(Scanner scanner) {
      this.scanner = scanner;
      this.employeeSet = (Set<Employee>)(new LinkedHashSet<Employee>());
 
      for(int index = 1; index < 11; ++index) {
         this.employeeSet.add(new Employee(index, "name: " + index, index + 10, "desig " + index, "depart " + index, (double)(index + 100)));
      }
 
   }
 
   public final void addEmployee() {

      int id = getIntegerUserInput("Enter ID: ");
      String name = getStringUserInput("Enter name: ");
      int age = getIntegerUserInput("Enter Age: ");
      String designation = getStringUserInput("Enter Designation: ");
      String department = getStringUserInput("Enter Department: ");
      int salary = getIntegerUserInput("Enter Salary: ");

      this.employeeSet.add(new Employee(id, name, age, designation, department, (double)salary));
      System.out.println("Employee Added successfully");

   } 

   public final void removeEmployee(final int empId) {
      Iterator<Employee> iterator = employeeSet.iterator();
      boolean removed = false;
      while (iterator.hasNext()) {
         Employee employee = iterator.next();
         if (employee.getId() == empId) {
            iterator.remove();
            removed = true;
            break;
         }
      }

      if (removed) {
         System.out.println("Employee Removed Successfully");
      } else {
         System.out.println("There is no employee with ID: " + empId);
      }
    
   }

   public final void viewEmployee(int empId) {
      List<Employee> employee = employeeSet.stream()
                                            .filter(emp -> emp.getId() == empId)
                                            .collect(Collectors.toList());
      if (!employee.isEmpty()) {
         Employee emp = employee.get(0);
         System.out.println("------------------------------------------------------------------------");
         System.out.println("-------                     Employee Details                     -------");
         System.out.println("------------------------------------------------------------------------");
         System.out.printf("| %-25s : %-40s |\n", "ID", emp.getId());
         System.out.printf("| %-25s : %-40s |\n", "Name", emp.getName());
         System.out.printf("| %-25s : %-40s |\n", "Age", emp.getAge());
         System.out.printf("| %-25s : %-40s |\n", "Designation", emp.getDesignation());
         System.out.printf("| %-25s : %-40s |\n", "Department", emp.getDepartment());
         System.out.printf("| %-25s : %-40s |\n", "Salary", emp.getSalary());
         System.out.println("------------------------------------------------------------------------");
      } else {
         System.out.println("Employee with ID: " + empId + " is not present");
      }
   }

 
   public final void viewAllEmployee() {

      if (!this.employeeSet.isEmpty()) {

         List<Employee> sortedEmployeesList = new ArrayList<>(employeeSet);

         Collections.sort(sortedEmployeesList, Comparator.comparing(Employee::getId));
         
         System.out.println("---------------------------------------------------------------------------------------------------------------------");
         System.out.printf("| %-5s | %-40s | %-3s | %-20s | %-20s | %-10s |\n", "Id", "Name", "Age", "Designation", "Department", "Salary");
         System.out.println("---------------------------------------------------------------------------------------------------------------------");


         for (Employee emp: sortedEmployeesList) {
            
            Object[] var6 = new Object[]{emp.getId(), emp.getName(), emp.getAge(), emp.getDesignation(), emp.getDepartment(), emp.getSalary()};

            System.out.printf("| %-5s | %-40s | %-3s | %-20s | %-20s | %-10s |\n", var6);

         }

         System.out.println("---------------------------------------------------------------------------------------------------------------------");
      } else {
         System.out.println("There are no employees to display!");
      } 
 
   }
 
   public final void updateEmployee() {

      int userInput = 0;
      while (userInput == 0) {
         userInput = this.getIntegerUserInput("Enter Employee ID: ");
      }
           
      boolean isEmployeePresent = false;

      for (Employee item: employeeSet) {
         if (item.getId() == userInput) {
            isEmployeePresent = true;
            break;
         }
      }
      
      int compareingValue = userInput;

      if (isEmployeePresent) {

         this.employeeSet.removeIf(emp -> emp.getId() == compareingValue);

         String name = this.getStringUserInput("Enter name: ");
         int age = this.getIntegerUserInput("Enter Age: ");
         String designation = this.getStringUserInput("Enter Designation: ");
         String department = this.getStringUserInput("Enter Department: ");
         int salary = this.getIntegerUserInput("Enter Salary: ");

         this.employeeSet.add(new Employee(userInput, name, age, designation, department, (double)salary));
      } else {
         System.out.println("There is no such employee");
      }
 
   }
 
   private final int getIntegerUserInput(String message) {
      int value = 0;
 
      while(value == 0) {
         System.out.print(message);
 
         try {
            value = this.scanner.nextInt();
         } catch (InputMismatchException var4) {
            System.out.println("Invalid Input! please enter numeric value only");
            this.scanner.nextLine();
            value = 0;
         }
      }
 
      return value;
   }
 
   private final String getStringUserInput(String message) {
      String value = "";
 
      while(value.equals("")) {
         System.out.print(message);
 
         try {
            value = this.scanner.nextLine();
         } catch (InputMismatchException e) {
            System.out.println("Invalid Input!");
            this.scanner.nextLine();
            value = "";
         }
      }
 
      return value;
   }
 
}