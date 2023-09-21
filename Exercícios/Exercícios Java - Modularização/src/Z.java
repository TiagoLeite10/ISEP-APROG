import java.util.Scanner;

// Z - Primo a tempo inteiro
public class Z {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int limitOne, limitTwo;

        limitOne = read.nextInt();
        limitTwo = read.nextInt();

        processFullTimePrimes(limitOne, limitTwo);

    }

    // Procedimento para processar os números primos a tempo inteiro de um intervalo
    private static void processFullTimePrimes(int inferiorLimit, int superiorLimit) {

        int numberOfFullTimePrimes = 0;

        if (inferiorLimit > superiorLimit) {
            int borrowedNumber = superiorLimit;
            superiorLimit = inferiorLimit;
            inferiorLimit = borrowedNumber;
        }

        for (int number = inferiorLimit; number <= superiorLimit; number++) {
            if ( isFullTimePrime(number) ) {
                numberOfFullTimePrimes++;
                System.out.println(number);
            }
        }

        System.out.println("(" + numberOfFullTimePrimes + ")");

    }

    // Função para verificar se um dado número é número primo a tempo inteiro
    private static boolean isFullTimePrime(int number) {

        int digit;
        int tempNumber = number;
        boolean isFullTimePrimeNumber;
        int numberOfDigits = countDigits(number);

        do {
            digit = tempNumber % 10;
            tempNumber /= 10;
            tempNumber = (digit * (int) Math.pow(10, numberOfDigits - 1)) + tempNumber;
            isFullTimePrimeNumber = isPrimeNumber(tempNumber);
        } while (isFullTimePrimeNumber && tempNumber != number);

        return isFullTimePrimeNumber;

    }

    // Função para contar o número de digitos de um dado número
    private static int countDigits(int number) {

        int numberOfDigits = 1;

        while (number > 9) {
            number /= 10;
            numberOfDigits++;
        }

        return numberOfDigits;

    }

    // Função para verificar se um dado número é número primo
    private static boolean isPrimeNumber(int number) {

        boolean isPrime = true;
        int i = 2;

        do {
            if (number % i == 0) {
                isPrime = false;
            }
            i++;
        } while (i <= Math.sqrt(number) && isPrime);

        return isPrime;

    }

}
