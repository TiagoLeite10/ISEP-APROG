import java.util.Scanner;

// G - Números de Armstrong
public class G {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int maxNumber = read.nextInt();

        for (int actualNumber = 0; actualNumber <= maxNumber ; actualNumber++) {

            if (isArmstrongNumber(actualNumber)) {
                System.out.println(actualNumber);
            }

        }

    }

    // Função para verificar se um número é um número de Armstrong
    private static boolean isArmstrongNumber(int number) {

        int sum = 0;
        int tempNumber = number;
        int totalDigits = countDigits(number);

        do {

            int digit = tempNumber % 10;

            sum += Math.pow(digit, totalDigits);

            tempNumber /= 10;

        } while (tempNumber > 0);

        return number == sum;

    }

    // Função para contar o número de digitos de um dado número
    private static int countDigits(int number) {

        int numberOfDigits = 1;

        while (number > 9) {

            numberOfDigits++;
            number /= 10;

        }

        return numberOfDigits;

    }

}
