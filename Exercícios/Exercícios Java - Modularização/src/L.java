import java.util.Scanner;

// L - Quantidade de palavras de uma frase
public class L {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        String phrase = read.nextLine();
        System.out.println(amountOfWords(phrase));

    }

    // Função para contar o número de palavras existentes numa frase
    private static int amountOfWords(String phrase) {

        boolean isWord = false;
        int numOfWords = 0;

        for (int i = 0; i < phrase.length(); i++) {

            if (phrase.charAt(i) == ' ') {
                isWord = false;
            } else if (isWord == false) {
                numOfWords++;
                isWord = true;
            }

        }

        return numOfWords;

    }

}
