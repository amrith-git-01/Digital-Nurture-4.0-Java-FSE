package Week_1.Data_Structures_and_Algorithms.Exercise_1_Inventory_Management_System.Code;
public class Product {
  private int productID;
  private String productName;
  private int productQuantity;
  private int productPrice;

  public Product(int productID, String productName, int productQuantity, int productPrice) {
    this.productID = productID;
    this.productName = productName;
    this.productQuantity = productQuantity;
    this.productPrice = productPrice;
  }

  public int getProductID() {
    return productID;
  }

  public void setProductID(int productID) {
    this.productID = productID;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getProductQuantity() {
    return productQuantity;
  }

  public void setProductQuantity(int productQuantity) {
    this.productQuantity = productQuantity;
  }

  public int getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(int productPrice) {
    this.productPrice = productPrice;
  }

  @Override
  public String toString() {
    return "\nProduct ID: " + productID + "\nProduct Name: " + productName + "\nProduct Quantity: " + productQuantity
        + "\nProduct Price: " + productPrice + "\n";
  }
}
