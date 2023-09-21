import java.util.Scanner;

// L - Vizinhos
public class L {

    private static Scanner read = new Scanner(System.in);
    private static final int MAX_READABLE_NUMBERS = 30;

    public static void main(String[] args) {

        int[] setOfNumbers = new int[MAX_READABLE_NUMBERS];
        readSetOfNumbers(setOfNumbers);
        printNumbersGreaterNeighbor(setOfNumbers);

    }

    // Procedimento para ler um conjunto de números inteiros
    private static void readSetOfNumbers(int[] setOfNumbers) {

        int number = 0;
        int readNumber;

        do {
            readNumber = read.nextInt();

            setOfNumbers[number] = readNumber;
            number++;

        } while (number < MAX_READABLE_NUMBERS && readNumber >= 0);

    }

    // Procedimento para visualizar todos os números maiores do que os seus vizinhos
    private static void printNumbersGreaterNeighbor(int[] setOfNumbers) {

        int i = 0;

        while (setOfNumbers[i] >= 0 && setOfNumbers[i + 1] >= 0) {
            if (i >= 1 && (setOfNumbers[i] > setOfNumbers[i - 1] && setOfNumbers[i] > setOfNumbers[i + 1])) {
                System.out.println(setOfNumbers[i]);
            }
            i++;
        }

    }

}
