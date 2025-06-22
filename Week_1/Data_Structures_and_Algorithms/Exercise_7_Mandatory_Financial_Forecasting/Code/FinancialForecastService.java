public class FinancialForecastService {

  public double calculateFutureValueRecursive(double principal, double rate, int years) {
    if (years == 0) {
      return principal;
    }
    return calculateFutureValueRecursive(principal * (1 + rate), rate, years - 1);
  }

  public double calculateFutureValueMemoized(double principal, double rate, int years, Double[] memo) {
    if (years == 0) return principal;
    if (memo[years] != null) return memo[years];
    memo[years] = calculateFutureValueMemoized(principal * (1 + rate), rate, years - 1, memo);
    return memo[years];
  }
}
