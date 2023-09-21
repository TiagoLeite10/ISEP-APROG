import java.util.Scanner;

// G - Divisores de um números
public class G {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int numero, contarDivisores = 0;

        numero = ler.nextInt();
        while (numero <= 0) {
            numero = ler.nextInt();
        }

        for (int i = 1; i <= numero; i++) {
            if (numero % i == 0) {
                System.out.println(i);
                contarDivisores++;
            }
        }

        System.out.println("(" + contarDivisores + ")");
    }

}
