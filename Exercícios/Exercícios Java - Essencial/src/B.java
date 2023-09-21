import java.util.Scanner;

// B - Somar algarismos pares (v2)
public class B {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int numero, somaPares = 0, digito;

        numero = ler.nextInt();

        while (numero > 0) {
            do {
                digito = numero % 10;
                if (digito % 2 == 0) {
                    somaPares += digito;
                }
                numero /= 10;
            } while (numero > 0);
            System.out.println(somaPares);
            somaPares = 0;
            numero = ler.nextInt();
        }
    }

}
