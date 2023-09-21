import java.util.Scanner;

// L - Números perfeitos
public class L {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int firstPerfectNumbers, perfectNumbersFound = 0, actualNumber = 6, divisorsSum = 0;

        firstPerfectNumbers = read.nextInt();
        if (firstPerfectNumbers >= 1) {

            do {

                for (int i = 1; i <= actualNumber / 2; i++) {
                    if (actualNumber % i == 0) {
                        divisorsSum += i;
                    }
                }

                if (divisorsSum == actualNumber) {
                    perfectNumbersFound++;
                    System.out.println(actualNumber);
                }

                divisorsSum = 0;
                actualNumber++;

            } while (perfectNumbersFound != firstPerfectNumbers);

        }

    }

}
