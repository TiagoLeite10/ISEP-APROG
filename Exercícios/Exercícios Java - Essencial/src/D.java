import java.util.Scanner;

// D - Produto dos algarismos impares (v2)
public class D {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numero, multImpares = 1, digito;
        boolean existeImpares = false;

        numero = ler.nextInt();

        while (numero > 0) {

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

            multImpares = 1;
            existeImpares = false;
            numero = ler.nextInt();
        }


    }

}
