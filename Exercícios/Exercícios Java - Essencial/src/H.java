import java.util.Scanner;

// H - Número primo
public class H {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numero = 0, divisor = 2;
        double raizQNumero;
        boolean numPrimo = true;

        while (numero <= 0) {
            numero = ler.nextInt();
        }

        raizQNumero = Math.sqrt(numero);

        while (numPrimo && divisor <= raizQNumero) {
            if (numero % divisor == 0) {
                numPrimo = false;
            }
            divisor++;
        }

        if (numPrimo && numero != 1) {
            System.out.println("primo");
        } else {
            System.out.println("nao e primo");
        }

    }

}
