import java.util.Scanner;

// X - Palíndromo
public class X {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        int readWords = readWords();
        System.out.println(readWords);

    }

    // Função para ler e contar o número de palavras lidas que antecedem a palavra palíndroma
    private static int readWords() {

        int readWords = 0;
        boolean isPalindromo;
        String word;

        do {
            word = read.next();
            isPalindromo = isPalindromo(word);
            if (!isPalindromo) {
                readWords++;
            }
        } while (!isPalindromo);

        return readWords;

    }

    // Função para verificar se uma palavra é um palíndromo
    private static boolean isPalindromo(String word) {

        String reversedWord = reverseWord(word);

        return word.equals(reversedWord);

    }

    // Função para inverter uma palavra (escrever de trás para a frente)
    private static String reverseWord(String word) {
        String reversedWord = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord += word.charAt(i);
        }

        return reversedWord;
    }

}
