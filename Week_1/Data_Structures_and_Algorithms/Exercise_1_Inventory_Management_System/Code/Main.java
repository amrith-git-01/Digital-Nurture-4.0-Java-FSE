package Week_1.Data_Structures_and_Algorithms.Exercise_1_Inventory_Management_System.Code;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ProductService productService = new ProductService();
    int choice = 0;
    while (true) {
      printMenu();
      System.out.println("Enter your choice: ");
      choice = scanner.nextInt();
      switch (choice) {
        case 1 -> {
          productService.addProduct();
        }
        case 2 -> {
          productService.updateProduct();
        }
        case 3 -> {
          productService.deleteProduct();
        }
        case 4 -> {
          productService.displayProduct();
        }
        case 5 -> {
          productService.displayAllProducts();
        }
        case 6 -> {
          System.out.println("Exiting!!!");
          scanner.close();
          break;
        }
        default -> {
          System.out.println("Enter a valid choice!!!");
        }
      }
    }
  }

  public static void printMenu() {
    System.out.println("XXXXXXXXXXXXXXXXXXXX");
    System.out.println("1)Add Product\n2)Update Product\n3)Delete Product\n4)Display Product\n5)Display all Products\n6)Exit");
    System.out.println("XXXXXXXXXXXXXXXXXXXX");
  }
}