import java.util.Scanner;

// M - Algarismos diferentes
public class M {

    private static final Scanner read = new Scanner(System.in);
    private static final int MAX_INPUT_NUMBERS = 100;
    private static final int MAX_DIGITS_PER_NUMBER = 10;

    public static void main(String[] args) {

        int number;
        int countInputNumbers = 0;

        do {
            number = read.nextInt();
            printResult(number);
            countInputNumbers++;
        } while (number >= 0 && countInputNumbers < MAX_INPUT_NUMBERS);

    }

    // Procedimento para imprimir o resultado
    private static void printResult(int number) {
        if (number >= 0) {
            System.out.println(number + ":" + numberOfDifferentNumbers(number));
        }
    }

    // Função para contar a quantidade de algarismos exclusivos num dado número
    private static int numberOfDifferentNumbers(int number) {

        int[] digitsNumber = new int[MAX_DIGITS_PER_NUMBER];
        int digit;
        int positionNewNumber = 0;

        do {

            digit = number % 10;

            if (!existsSameNumberInArray(digitsNumber, digit, positionNewNumber)) {
                digitsNumber[positionNewNumber] = digit;
                positionNewNumber++;
            }

            number /= 10;

        } while (number > 0);

        return positionNewNumber;

    }

    // Função para verificar se já existe um determinado número no array
    private static boolean existsSameNumberInArray(int[] arrayOfIntegers, int number, int numbersInArray) {

        boolean foundSameNumber = false;
        int positionToRead = 0;

        while (!foundSameNumber && positionToRead < numbersInArray) {

            if (number == arrayOfIntegers[positionToRead]) {
                foundSameNumber = true;
            }

            positionToRead++;
        }

        return foundSameNumber;

    }

}
