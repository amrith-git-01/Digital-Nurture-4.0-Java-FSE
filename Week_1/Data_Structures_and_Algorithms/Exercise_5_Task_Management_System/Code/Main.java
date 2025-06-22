import java.util.Scanner;

public class Main {
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    TaskService taskService = new TaskService();
    int choice = 0;
    while (true) {
      printMenu();
      System.out.println("Enter your choice: ");
      choice = scanner.nextInt();
      switch (choice) {
        case 1 -> {
          taskService.addTask();
        }
        case 2 -> {
          taskService.deleteTask();
        }
        case 3 -> {
          taskService.searchTask();
        }
        case 4 -> {
          taskService.displayAllTasks();
        }
        case 5 -> {
          System.out.println("Exiting!!!");
          return;
        }
        default -> {
          System.out.println("Enter a valid choice!!!");
        }
      }
    }
  }

  public static void printMenu() {
    System.out.println("XXXXXXXXXXXXXXXXXXXX");
    System.out.println("1)Add Task\n2)Delete Task\n3)Search Task\n4)Display Tasks\n5)Exit");
    System.out.println("XXXXXXXXXXXXXXXXXXXX");
  }
}
