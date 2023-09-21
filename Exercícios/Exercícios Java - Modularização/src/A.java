import java.util.Scanner;

// A - Média de números com menos de X algarismos
public class A {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        final int NUM_MAX_OF_NUMBERS = 5;
        int numMaxDigits;
        int number;
        int totalValidNumbers = 0;
        int sumNumbers = 0;

        numMaxDigits = read.nextInt();

        do {

            number = read.nextInt();

            if (countDigits(number) < numMaxDigits) {
                sumNumbers += number;
                totalValidNumbers++;
            }

        } while ((countDigits(number) < numMaxDigits) && (totalValidNumbers < NUM_MAX_OF_NUMBERS));

        System.out.printf("%.2f\n", (double) sumNumbers / totalValidNumbers);

    }

    // Função para contar a quantidade de digitos que um dado número tem
    private static int countDigits(int number) {

        int numberOfDigits = 0;

        while (number > 0) {

            numberOfDigits++;
            number /= 10;

        }

        return numberOfDigits;

    }

}
