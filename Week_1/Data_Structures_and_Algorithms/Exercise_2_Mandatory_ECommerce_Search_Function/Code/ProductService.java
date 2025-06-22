import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ProductService {
  private Product[] products;
  private int curSize;
  private int size;
  private Scanner scanner = new Scanner(System.in);

  public ProductService(int size) {
    this.size = size;
    this.products = new Product[size];
    this.curSize = -1;
  }

  public void addProduct() {
    if (curSize == size - 1) {
      System.out.println("Product list is full!");
      return;
    }

    System.out.print("Enter Product ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enter Product Name: ");
    String name = scanner.nextLine();

    System.out.print("Enter Product Category: ");
    String category = scanner.nextLine();

    products[++curSize] = new Product(id, name, category);
    System.out.println("Product added successfully!");
  }

  public void linearSearchProduct() {
    if (curSize == -1) {
      System.out.println("No products available.");
      return;
    }

    System.out.print("Enter Product ID to search (Linear): ");
    int id = scanner.nextInt();
    Product product = linearSearch(id);

    if (product != null) {
      System.out.println("Product Found: " + product);
    } else {
      System.out.println("Product not found.");
    }
  }

  public void binarySearchProduct() {
    if (curSize == -1) {
      System.out.println("No products available.");
      return;
    }

    sortProducts();

    System.out.print("Enter Product ID to search (Binary): ");
    int id = scanner.nextInt();
    Product product = binarySearch(id);

    if (product != null) {
      System.out.println("Product Found: " + product);
    } else {
      System.out.println("Product not found.");
    }
  }

  public void displayAllProducts() {
    if (curSize == -1) {
      System.out.println("No products available.");
      return;
    }

    for (int i = 0; i <= curSize; i++) {
      System.out.println(products[i]);
    }
  }

  private Product linearSearch(int id) {
    for (int i = 0; i <= curSize; i++) {
      if (products[i].productId == id) {
        return products[i];
      }
    }
    return null;
  }

  private Product binarySearch(int id) {
    int left = 0, right = curSize;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (products[mid].productId == id) {
        return products[mid];
      } else if (products[mid].productId < id) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return null;
  }

  private void sortProducts() {
    Arrays.sort(products, 0, curSize + 1, Comparator.comparingInt(p -> p.productId));
  }
}
