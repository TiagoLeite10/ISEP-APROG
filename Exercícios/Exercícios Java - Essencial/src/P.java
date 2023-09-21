import java.util.Scanner;

// P - Algarismos Repetidos
public class P {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int originalNumber, digitToAnalyze, digit, numberToAnalyze, numberWithDigitsToAnalyze;
        int posDigitToAnalyze, posDigit;
        boolean foundSameNumber;

        originalNumber = read.nextInt();

        // Enquanto o número introduzido pelo utilizador não for negativo
        while (originalNumber >= 0) {

            numberToAnalyze = originalNumber;
            numberWithDigitsToAnalyze = originalNumber;
            posDigitToAnalyze = 0;
            foundSameNumber = false;

            // Enquanto não forem analisados todos os digitos do número
            do {

                posDigitToAnalyze++;

                posDigit = posDigitToAnalyze;

                // Algarismo a ser analisado
                digitToAnalyze = numberWithDigitsToAnalyze % 10;

                // Retirar o algarismo mais à direita do número a analisar, pois esse algarismo corresponde àquele que
                //está a ser analisado
                numberToAnalyze /= 10;

                while (numberToAnalyze > 0 && ! foundSameNumber) {

                    digit = numberToAnalyze % 10;

                    foundSameNumber = (digitToAnalyze == digit);

                    numberToAnalyze /= 10;

                    posDigit++;

                }

                numberWithDigitsToAnalyze /= 10;
                // Utilizar apenas os algarismos que ainda não foram analisados como primeiro número
                numberToAnalyze = numberWithDigitsToAnalyze;

            } while (numberWithDigitsToAnalyze > 0 && ! foundSameNumber);

            if (foundSameNumber) {
                System.out.println(originalNumber + " : algarismo (" + digitToAnalyze
                        + ") repetido nas posicoes " + "(" + posDigitToAnalyze + ")" + " e " + "("
                        + posDigit + ")");
            }

            originalNumber = read.nextInt();

        }

    }

}
