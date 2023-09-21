import java.util.Scanner;

// H - Capicua
public class H {

    final static int maxAttempts = 5;

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        boolean capicuaFound = false;
        int attempt = 1;

        while (attempt <= maxAttempts && !capicuaFound) {

            if (isCapicua(read.nextInt())) {
                capicuaFound = true;
                System.out.println("capicua");
            }
            attempt++;

        }

        if (!capicuaFound) {
            System.out.println("tentativas excedidas");
        }

    }

    // Função para verificar se um número é ou não capicua
    private static boolean isCapicua(int number) {

        int invertedNumber = 0;
        int tempNumber = number;

        do {

            int digit = tempNumber % 10;
            invertedNumber = (invertedNumber * 10) + digit;
            tempNumber /= 10;

        } while (tempNumber > 0);

        return invertedNumber == number;

    }

}
