import java.util.Scanner;

// A - Somar algarismos pares
public class A {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numero, somaPares = 0, digito;

        numero = ler.nextInt();
        while (numero <= 0) {
            System.out.println("Número inválido!");
            numero = ler.nextInt();
        }

        do {
            digito = numero % 10;
            if (digito % 2 == 0) {
                somaPares += digito;
            }
            numero /= 10;
        } while (numero > 0);

        System.out.println(somaPares);

    }

}
