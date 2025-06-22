import java.util.Scanner;

public class TaskService {
  class Node {
    Task task;
    Node next;

    Node(Task task) {
      this.task = task;
      this.next = null;
    }
  }

  private Node head;
  Scanner scanner = new Scanner(System.in);

  public TaskService() {
    head = null;
  }

  public void addTask() {
    System.out.print("Enter the task id: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    if (checkId(id)) {
      System.out.println("Task already exists!");
      return;
    }

    System.out.print("Enter the task name: ");
    String name = scanner.nextLine();

    System.out.print("Enter the task status (pending/done): ");
    String status = scanner.nextLine();

    if (checkValid(status)) {
      Task task = new Task(id, name, status.toLowerCase());
      addNode(task);
      System.out.println("Task added successfully.");
    } else {
      System.out.println("Invalid status! Only 'pending' or 'done' are allowed.");
    }
  }

  private void addNode(Task task) {
    Node newNode = new Node(task);
    if (head == null) {
      head = newNode;
    } else {
      Node temp = head;
      while (temp.next != null) {
        temp = temp.next;
      }
      temp.next = newNode;
    }
  }

  public void deleteTask() {
    if (head == null) {
      System.out.println("No tasks to delete.");
      return;
    }

    System.out.print("Enter task id to delete: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    if (head.task.getTaskId() == id) {
      head = head.next;
      System.out.println("Task deleted.");
      return;
    }

    Node temp = head;
    while (temp.next != null && temp.next.task.getTaskId() != id) {
      temp = temp.next;
    }

    if (temp.next == null) {
      System.out.println("Task not found.");
    } else {
      temp.next = temp.next.next;
      System.out.println("Task deleted.");
    }
  }

  public void searchTask() {
    if (head == null) {
      System.out.println("No tasks available.");
      return;
    }

    System.out.print("Enter task id to search: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    Node temp = head;
    while (temp != null) {
      if (temp.task.getTaskId() == id) {
        System.out.println("Task Found: " + temp.task);
        return;
      }
      temp = temp.next;
    }

    System.out.println("Task not found.");
  }

  public void displayAllTasks() {
    if (head == null) {
      System.out.println("No tasks to display.");
      return;
    }

    Node temp = head;
    while (temp != null) {
      System.out.println(temp.task);
      temp = temp.next;
    }
  }

  private boolean checkId(int id) {
    Node temp = head;
    while (temp != null) {
      if (temp.task.getTaskId() == id) {
        return true;
      }
      temp = temp.next;
    }
    return false;
  }

  private boolean checkValid(String status) {
    status = status.toLowerCase();
    return status.equals("pending") || status.equals("done");
  }
}
