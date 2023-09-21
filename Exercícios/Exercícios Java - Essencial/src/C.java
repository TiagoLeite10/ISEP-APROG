import java.util.Scanner;

// C - Produto dos algarismos impares
public class C {
    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numero, multImpares = 1, digito;
        boolean existeImpares = false;

        numero = ler.nextInt();
        while (numero <= 0) {
            System.out.println("Número inválido!");
            numero = ler.nextInt();
        }

        do {
            digito = numero % 10;
            if (digito % 2 != 0) {
                multImpares *= digito;
                existeImpares = true;
            }
            numero /= 10;
        } while (numero > 0);

        if (existeImpares) {
            System.out.println(multImpares);
        } else {
            System.out.println("nao ha algarismos impares");
        }

    }
}
