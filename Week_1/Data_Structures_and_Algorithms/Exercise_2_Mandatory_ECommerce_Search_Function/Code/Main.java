import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter number of products: ");
    int size = scanner.nextInt();

    ProductService productService = new ProductService(size);

    while (true) {
      printMenu();
      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1 -> productService.addProduct();
        case 2 -> productService.linearSearchProduct();
        case 3 -> productService.binarySearchProduct();
        case 4 -> productService.displayAllProducts();
        case 5 -> {
          System.out.println("Exiting program...");
          return;
        }
        default -> System.out.println("Invalid choice!");
      }
    }
  }

  public static void printMenu() {
    System.out.println("\n========= Product Search Menu =========");
    System.out.println("1. Add Product");
    System.out.println("2. Linear Search by Product ID");
    System.out.println("3. Binary Search by Product ID");
    System.out.println("4. Display All Products");
    System.out.println("5. Exit");
    System.out.println("=======================================");
  }
}
