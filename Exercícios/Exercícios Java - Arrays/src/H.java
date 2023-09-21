import java.util.Scanner;

// H - Rodar sequência
public class H {

    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        int totalOfNumbers = read.nextInt();
        int[] numbersSet = readSetOfNumbers(totalOfNumbers);
        processComands(numbersSet);

    }

    // Procedimento para processar os comandos de rotação do array
    private static void processComands(int[] numbersSet) {
        String command;
        do {
            command = readCommand();
            switch (command) {
                case "direita":
                    rightRotateArray(numbersSet);
                    printValues(numbersSet);
                    break;
                case "esquerda":
                    leftRotateArray(numbersSet);
                    printValues(numbersSet);
                    break;
                default:
                    break;
            }
        } while(! command.equals("sair"));
    }

    // Função para ler um comando
    private static String readCommand() {
        String command;
        do {
            command = read.next();
        } while(! command.equals("direita") && ! command.equals("esquerda") && ! command.equals("sair"));

        return command;
    }

    // Função para ler um conjunto de números
    private static int[] readSetOfNumbers(int totalOfNumbers) {

        int[] numbersSet = new int[totalOfNumbers];

        for (int position = 0; position < totalOfNumbers; position++) {
            numbersSet[position] = read.nextInt();
        }

        return numbersSet;

    }

    // Procedimento para imprimir informação acerca dos valores do conjunto
    private static void printValues(int[] numbersSet) {

        for (int position = 0; position < numbersSet.length; position++) {
            System.out.print("[" + numbersSet[position] + "]");
        }
        System.out.println("");
    }

    // Procedimento para rodar a sequência de números para a esquerda em uma posição
    private static void leftRotateArray(int[] numbersSet) {

        int firstNumber = numbersSet[0];

        for (int i = 0; i < numbersSet.length - 1; i++) {
            numbersSet[i] = numbersSet[i + 1];
        }

        numbersSet[numbersSet.length - 1] = firstNumber;

    }

    // Procedimento para rodar a sequência de números para a direita em uma posição
    private static void rightRotateArray(int[] numbersSet) {

        int lastNumber = numbersSet[numbersSet.length - 1];

        for (int i = numbersSet.length - 1; i > 0; i--) {
            numbersSet[i] = numbersSet[i - 1];
        }

        numbersSet[0] = lastNumber;

    }

}
