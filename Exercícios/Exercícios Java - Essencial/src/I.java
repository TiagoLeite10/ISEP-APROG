import java.util.Scanner;

// I - Mínimo múltiplo comum
public class I {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int number1, number2, mmc;

        number1 = ler.nextInt();
        while (number1 <= 0) {
            number1 = ler.nextInt();
        }

        number2 = ler.nextInt();
        while (number2 <= 0) {
            number2 = ler.nextInt();
        }

        // O número 1 fica sempre com o valor mais alto (se não forem dois números iguais)
        if (number1 < number2) {
            int tempNumber = number1;
            number1 = number2;
            number2 = tempNumber;
        }

        mmc = number1;

        // Para achar o mínimo múltiplo comum, basta achar o menor valor na tabuada do maior número
        //que seja divisivel pelo número mais pequeno introduzido (resto 0)
        while (mmc % number2 != 0) {
            mmc += number1;
        }

        System.out.println(mmc);

    }

}
