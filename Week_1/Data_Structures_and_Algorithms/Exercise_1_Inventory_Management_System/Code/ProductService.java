package Week_1.Data_Structures_and_Algorithms.Exercise_1_Inventory_Management_System.Code;
import java.util.TreeMap;
import java.util.Scanner;

public class ProductService {
  private TreeMap<Integer, Product> products = new TreeMap<Integer, Product>();
  Scanner scanner = new Scanner(System.in);

  public void addProduct() {
    System.out.println("Enter the following product details: ");
    System.out.println("Product Id: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    if (checkId(id)) {
      System.out.println("Product alreasy exists!!!");
    } else {
      System.out.println("Product Name: ");
      String name = scanner.nextLine();
      System.out.println("Product Quantity: ");
      int quantity = scanner.nextInt();
      System.out.println("Product Price: ");
      int price = scanner.nextInt();
      products.put(id, new Product(id, name, quantity, price));
      System.out.println("Product added successfully!!!");
    }
  }

  public void deleteProduct() {
    System.out.println("Enter the productID to delete: ");
    int id = scanner.nextInt();
    if (checkId(id)) {
      products.remove(id);
      System.out.println("Product deleted successfully!!!");
    } else {
      notFoundMessage();
    }
  }

  public void updateProduct() {
    int choice = 0;
    System.out.println("Enter the productID to update: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    if (checkId(id)) {
      printUpdateProduct();
      Product product = products.get(id);
      System.out.println("Enter your choice: ");
      choice = scanner.nextInt();
      scanner.nextLine();
      switch (choice) {
        case 1 -> {
          System.out.println("Enter the new Product Name: ");
          String newName = scanner.nextLine();
          String oldName = product.getProductName();
          product.setProductName(newName);
          System.out.println("The name is changed from " + oldName + " to " + newName);
        }
        case 2 -> {
          System.out.println("Enter the new Product Quantity");
          int newQuantity = scanner.nextInt();
          int oldQuantity = product.getProductQuantity();
          product.setProductQuantity(newQuantity);
          System.out.println("The quantity is changed from " + oldQuantity + " to " + newQuantity);
        }
        case 3 -> {
          System.out.println("Enter the new Product Price");
          int newPrice = scanner.nextInt();
          int oldPrice = product.getProductQuantity();
          product.setProductPrice(newPrice);
          System.out.println("The price is changed from " + oldPrice + " to " + newPrice);
        }
        default -> {
          System.out.println("Enter a valid choice!!!");
        }
      }
    } else {
      notFoundMessage();
    }
  }

  public void displayProduct() {
    System.out.println("Enter the productID");
    int id = scanner.nextInt();

    if (checkId(id)) {
      System.out.println(products.get(id));
    } else {
      notFoundMessage();
    }
  }

  public void displayAllProducts() {
    if (products.isEmpty()) {
      System.out.println("There are not prodcts added!!!");
    } else {
      for (Product product : products.values()) {
        System.out.println(product);
      }
    }
  }

  public boolean checkId(int id) {
    return products.containsKey(id);
  }

  public void printUpdateProduct() {
    System.out.println("XXXXXXXXXXXXXXX");
    System.out.println("1)Product Name\n2)Product Quantity\n3)Product Price");
    System.out.println("XXXXXXXXXXXXXXX");
  }

  public void notFoundMessage() {
    System.out.println("The product with provided productID not found!!!");
  }
}
