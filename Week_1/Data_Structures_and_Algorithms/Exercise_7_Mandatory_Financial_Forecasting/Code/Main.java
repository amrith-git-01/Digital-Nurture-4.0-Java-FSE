import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    FinancialForecastService service = new FinancialForecastService();

    System.out.print("Enter the present value: ");
    double principal = scanner.nextDouble();

    System.out.print("Enter annual growth rate (in %): ");
    double rate = scanner.nextDouble() / 100.0;

    System.out.print("Enter number of years: ");
    int years = scanner.nextInt();

    System.out.println("\n=== Recursive Calculation ===");
    double futureValueRec = service.calculateFutureValueRecursive(principal, rate, years);
    System.out.printf("Future Value (Recursive): %.2f\n", futureValueRec);

    System.out.println("\n=== Memoized Calculation ===");
    Double[] memo = new Double[years + 1];
    double futureValueMemo = service.calculateFutureValueMemoized(principal, rate, years, memo);
    System.out.printf("Future Value (Memoized): %.2f\n", futureValueMemo);
  }
}
