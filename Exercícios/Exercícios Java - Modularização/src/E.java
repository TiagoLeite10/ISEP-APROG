import java.util.Scanner;

// E - Algarismos em posições comuns
public class E {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int totalNumbersPairs;
        int betterPairNumberOne = 0, betterPairNumberTwo = 0, amountBetterPair = 0;

        do {
            totalNumbersPairs = read.nextInt();
        } while (totalNumbersPairs <= 0);

        for (int i = 0; i < totalNumbersPairs; i++) {

            int numberOne;
            do {
                numberOne = read.nextInt();
            } while (numberOne <= 0);

            int numberTwo;
            do {
                numberTwo = read.nextInt();
            } while (numberTwo <= 0);

            int numbersSamePosition = numbersSamePosition(numberOne, numberTwo);
            if (numbersSamePosition >= amountBetterPair) {
                betterPairNumberOne = numberOne;
                betterPairNumberTwo = numberTwo;
                amountBetterPair = numbersSamePosition;
            }

        }

        if (amountBetterPair > 0) {
            System.out.println(betterPairNumberOne + "/" + betterPairNumberTwo);
        } else {
            System.out.println("sem resultados");
        }

    }

    // Função para contar a quantidade de dígitos comuns nas mesmas posições entre dois números
    private static int numbersSamePosition(int numberOne, int numberTwo) {

        int totalNumbersSamePosition = 0;

        do {

            int digitNumberOne, digitNumberTwo;
            digitNumberOne = numberOne % 10;
            digitNumberTwo = numberTwo % 10;

            if (digitNumberOne == digitNumberTwo) {
                totalNumbersSamePosition++;
            }

            numberOne /= 10;
            numberTwo /= 10;

        } while (numberOne > 0 && numberTwo > 0);

        return totalNumbersSamePosition;

    }

}
