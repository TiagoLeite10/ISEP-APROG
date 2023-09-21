import java.util.Scanner;

// Z - Percentagem de algarismos pares e maior ímpar
public class Z {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int number, countDigits = 0, countEvenDigits = 0, biggerOddDigit = 1, digit;
        boolean hasOddDigits = false;

        do {
            number = read.nextInt();
        } while (number < 1);

        while (number > 0) {

            digit = number % 10;

            if (digit % 2 == 0) {
                countEvenDigits++;
            } else {
                hasOddDigits = true;
                if (digit > biggerOddDigit) {
                    biggerOddDigit = digit;
                }
            }

            countDigits++;
            number /= 10;

        }

        float percentEvenDigits = (float)(countEvenDigits * 100) / countDigits;
        System.out.printf("%.2f", percentEvenDigits);
        System.out.println("%");

        if (hasOddDigits) {
            System.out.println(biggerOddDigit);
        } else {
            System.out.println("nao ha algarismos impares");
        }

    }

}
