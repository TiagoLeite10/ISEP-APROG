import java.util.Scanner;

// E - Converter de base 8 para decimal
public class E {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numero, pos = 0, digito, numeroDecimal = 0;

        numero = ler.nextInt();

        while (numero > 0) {

            do {
                digito = numero % 10;
                numeroDecimal += digito * Math.pow(8, pos);
                numero /= 10;
                pos++;
            } while (numero > 0);

            System.out.println(numeroDecimal);

            pos = 0;
            numeroDecimal = 0;
            numero = ler.nextInt();

        }

    }

}
