import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {

      System.out.println("\n1)Word Document\n2)PDF Document\n3)Excel Document\n4)Exit\n");

      DocumentFactory factory = null;
      System.out.println("Enter your choice: ");
      int choice = scanner.nextInt();
      switch (choice) {
        case 1 -> {
          factory = new WordDocumentFactory();
        }
        case 2 -> {
          factory = new PdfDocumentFactory();
        }
        case 3 -> {
          factory = new ExcelDocumentFactory();
        }
        case 4 -> {
          System.out.println("Exiting!!!");
          scanner.close();
          return;
        }
        default -> {
          System.out.println("Invalid document type.");
        }
      }

      Document doc = factory.createDocument();
      doc.open();
    }
  }
}
