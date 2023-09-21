import java.util.Scanner;

// K - Números primos até um limite
public class K {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int number;

        number = read.nextInt();

        if (number > 1) {

            for (int actualNumber = 2; actualNumber <= number; actualNumber++) {

                double squareRoot = Math.sqrt(actualNumber);
                int numberActualNumber = 2;
                boolean primeNumber = true;

                while (primeNumber && numberActualNumber <= squareRoot) {
                    if (actualNumber % numberActualNumber == 0) {
                        primeNumber = false;
                    }
                    numberActualNumber++;
                }

                if (primeNumber) {
                    System.out.println(actualNumber);
                }

            }

        }

    }

}
