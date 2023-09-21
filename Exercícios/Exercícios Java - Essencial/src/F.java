import java.util.Scanner;

// F - Capicua
public class F {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numFinal = 0, numOriginal, numClone, digito;

        numOriginal = ler.nextInt();
        while (numOriginal <= 0) {
            System.out.println("Número inválido!");
            numOriginal = ler.nextInt();
        }

        numClone = numOriginal;

        do {
            digito = numClone % 10;
            numFinal = (numFinal * 10) + digito;
            numClone /= 10;
        } while (numClone > 0);

        if (numFinal == numOriginal) {
            System.out.println("capicua");
        } else {
            System.out.println("nao capicua");
        }

    }
}
