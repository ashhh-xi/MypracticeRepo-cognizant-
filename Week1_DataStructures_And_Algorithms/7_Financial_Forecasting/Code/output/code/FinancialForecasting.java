public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base case: if no periods are left, return the current value
        if (periods == 0) {
            return currentValue;
        }
        // Recursive step: calculate value for one period and recurse for the rest
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5%
        int periods = 10;

        double futureValue = calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("The future value after %d periods is: %.2f%n", periods, futureValue);
    }
} 