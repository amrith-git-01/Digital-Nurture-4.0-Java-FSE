public class Employee {
  private int employeeID;
  private String employeeName;
  private String position;
  private int salary;

  public Employee(int employeeID, String employeeName, String position, int salary) {
    this.employeeID = employeeID;
    this.employeeName = employeeName;
    this.position = position;
    this.salary = salary;
  }

  public int getEmployeeID() {
    return employeeID;
  }

  public void setEmployeeID(int employeeID) {
    this.employeeID = employeeID;
  }

  public String getEmployeeName() {
    return employeeName;
  }

  public void setEmployeeName(String employeeName) {
    this.employeeName = employeeName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "\nEmployee ID: " + employeeID +
           "\nEmployee Name: " + employeeName +
           "\nPosition: " + position +
           "\nSalary: " + salary + "\n";
  }
}
