package intermediate.employeemanagementapp.employeemanagement;


public final class Employee {

   private final int id;
   private final String name;
   private final int age;
   private final String designation;
   private final String department;
   private final double salary;
   
   public Employee(int id, String name, int age, String designation, String department, double salary) {
      this.id = id;
      this.name = name;
      this.age = age;
      this.designation = designation;
      this.department = department;
      this.salary = salary;
   }

   public final int getId() {
      return this.id;
   }

   public final String getName() {
      return this.name;
   }

   public final int getAge() {
      return this.age;
   }

   public final String getDesignation() {
      return this.designation;
   }

   public final String getDepartment() {
      return this.department;
   }

   public final double getSalary() {
      return this.salary;
   }

   public final Employee copy(int id, String name, int age, String designation, String department, double salary) {
      return new Employee(id, name, age, designation, department, salary);
   }

   public String toString() {
      return "Employee(id=" + this.id + ", name=" + this.name + ", age=" + this.age + ", designation=" + this.designation + ", department=" + this.department + ", salary=" + this.salary + ')';
   }

   public int hashCode() {
      int result = Integer.hashCode(this.id);
      result = result * 31 + this.name.hashCode();
      result = result * 31 + Integer.hashCode(this.age);
      result = result * 31 + this.designation.hashCode();
      result = result * 31 + this.department.hashCode();
      result = result * 31 + Double.hashCode(this.salary);
      return result;
   }
}
