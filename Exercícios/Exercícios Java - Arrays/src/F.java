import java.util.Scanner;

// F - Aplicação financeira
public class F {

    private static final int MONTHS = 6;
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        double[] fees = readFees();
        double initialDeposit = read.nextDouble();
        System.out.printf("%s%.2f%n", "valor final=", calculateFinalValue(initialDeposit, fees));

    }

    // Função para ler as taxas de juros para cada um dos 6 meses
    private static double[] readFees() {

        double[] fees = new double[MONTHS];

        for (int month = 0; month < MONTHS; month++) {
            fees[month] = read.nextDouble();
        }

        return fees;

    }

    // Função para calcular o montante final após os 6 meses de depósito
    private static double calculateFinalValue(double initialDeposit, double[] fees) {

        double finalValue = initialDeposit;

        for (int month = 0; month < MONTHS; month++) {

            finalValue += (fees[month] * finalValue);

        }

        return finalValue;

    }

}
