import java.util.Scanner;

public class EmployeeService {
  private Employee[] employees;
  private int curSize;
  private int size;
  Scanner scanner = new Scanner(System.in);

  public EmployeeService(int size) {
    this.employees = new Employee[size];
    this.curSize = -1;
    this.size = size;
  }

  public void addEmployee() {
    if (checkCapacity()) {
      System.out.println("Cannot add Employee, record full!");
      return;
    }

    System.out.print("Enter the employee ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (checkId(id)) {
      System.out.println("Employee already added!");
      return;
    }

    System.out.print("Enter the employee name: ");
    String name = scanner.nextLine();
    System.out.print("Enter the position: ");
    String position = scanner.nextLine();
    System.out.print("Enter the salary: ");
    int salary = scanner.nextInt();

    employees[++curSize] = new Employee(id, name, position, salary);
    System.out.println("Employee added successfully!");
  }

  public void deleteEmployee() {
    if (isEmpty()) {
      System.out.println("The employee records are empty!");
      return;
    }

    System.out.print("Enter the employee ID to delete: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (!checkId(id)) {
      System.out.println("Cannot find employee with the given ID");
      return;
    }

    int index = -1;
    for (int i = 0; i <= curSize; i++) {
      if (employees[i].getEmployeeID() == id) {
        index = i;
        break;
      }
    }

    shiftEmployee(index);
    System.out.println("Employee deleted successfully!");
  }

  public void searchEmployee() {
    if (isEmpty()) {
      System.out.println("The employee records are empty!");
      return;
    }

    System.out.print("Enter the employee ID to search: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Employee employee = searchId(id);
    if (employee == null) {
      System.out.println("Employee not found.");
    } else {
      System.out.println(employee);
    }
  }

  public void displayAllEmployees() {
    if (isEmpty()) {
      System.out.println("The employee records are empty!");
      return;
    }

    for (int i = 0; i <= curSize; i++) {
      System.out.println(employees[i]);
    }
  }

  private boolean checkCapacity() {
    return curSize == size - 1;
  }

  private boolean checkId(int id) {
    for (int i = 0; i <= curSize; i++) {
      if (employees[i].getEmployeeID() == id) {
        return true;
      }
    }
    return false;
  }

  private void shiftEmployee(int index) {
    for (int i = index; i < curSize; i++) {
      employees[i] = employees[i + 1];
    }
    employees[curSize] = null;
    curSize--;
  }

  private Employee searchId(int id) {
    for (int i = 0; i <= curSize; i++) {
      if (employees[i].getEmployeeID() == id) {
        return employees[i];
      }
    }
    return null;
  }

  private boolean isEmpty() {
    return curSize == -1;
  }
}
