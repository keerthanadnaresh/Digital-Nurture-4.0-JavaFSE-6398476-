public class FinancialForecast {

    
    public static double forecastValue(double presentValue, double rate, int years) {
        if (years == 0) {
            return presentValue;
        }
        
        return forecastValue(presentValue, rate, years - 1) * (1 + rate);
    }

    public static void main(String[] args) {
        double presentValue = 10000; 
        double rate = 0.05; 
        int years = 5;

        double futureValue = forecastValue(presentValue, rate, years);
        System.out.printf("Future value after %d years: INR %.2f%n", years, futureValue);

    }
}
