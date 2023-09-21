import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

// J - Percentagem de dígitos divisores do próprio número
public class J {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int totalNumbers;
        float highestPercentage = 0.0f;

        totalNumbers = read.nextInt();

        if (totalNumbers > 0) {
            int number;
            for (int i = 1; i <= totalNumbers; i++) {

                int numDigits = 0, divisorDigits = 0, digit, originalNumber;
                float percentageDivisors = 0.0f;

                do {
                    originalNumber = read.nextInt();
                } while (originalNumber <= 0);

                number = originalNumber;

                do {

                    digit = number % 10;

                    if (digit != 0 && originalNumber % digit == 0) {
                        divisorDigits++;
                    }

                    numDigits++;

                    number /= 10;

                } while (number > 0);

                percentageDivisors = (float)(divisorDigits * 100) / numDigits;
                System.out.printf("%.2f", percentageDivisors);
                System.out.println("%");

                if (percentageDivisors > highestPercentage || i == 1) {
                    highestPercentage = percentageDivisors;
                }

            }

            System.out.print("(");
            System.out.printf("%.2f", highestPercentage);
            System.out.println("%)");
        }

    }

}
