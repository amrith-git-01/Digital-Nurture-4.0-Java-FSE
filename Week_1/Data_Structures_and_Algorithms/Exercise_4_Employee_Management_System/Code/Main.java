import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the number of employees: ");
    int size = scanner.nextInt();
    EmployeeService employeeService = new EmployeeService(size);

    int choice;
    while (true) {
      printMenu();
      System.out.print("Enter your choice: ");
      choice = scanner.nextInt();

      switch (choice) {
        case 1 -> employeeService.addEmployee();
        case 2 -> employeeService.deleteEmployee();
        case 3 -> employeeService.searchEmployee();
        case 4 -> employeeService.displayAllEmployees();
        case 5 -> {
          System.out.println("Exiting!!!");
          return; // DO NOT close System.in
        }
        default -> System.out.println("Enter a valid choice!!!");
      }
    }
  }

  public static void printMenu() {
    System.out.println("\nXXXXXXXXXXXXXXXXXXXX");
    System.out.println("1) Add Employee");
    System.out.println("2) Delete Employee");
    System.out.println("3) Search Employee");
    System.out.println("4) Display Employees");
    System.out.println("5) Exit");
    System.out.println("XXXXXXXXXXXXXXXXXXXX");
  }
}
