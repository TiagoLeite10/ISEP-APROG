import java.util.Scanner;

// D - Combinações e permutações
public class D {

    public static void main(String[] args) {

        Scanner ler = new Scanner(System.in);
        int quantTotalElementos, quantAgrupar;

        quantTotalElementos = ler.nextInt();
        quantAgrupar = ler.nextInt();

        if (quantTotalElementos >= quantAgrupar) {
            System.out.println("C(" + quantTotalElementos + "," + quantAgrupar + ")=" + combinacoes(quantTotalElementos, quantAgrupar));
            System.out.println("P(" + quantTotalElementos + "," + quantAgrupar + ")=" + permutacoes(quantTotalElementos, quantAgrupar));
        }

    }

    // Função para calcular o fatorial de um número
    private static int fatorial(int numero) {

        int fatorial = 1;
        for (int i = numero; i >= 2; i--) {
            fatorial *= i;
        }

        return fatorial;

    }

    // Função para calcular a quantidade de combinações possíveis
    private static int combinacoes(int m, int n) {
        return ((fatorial(m)) / (fatorial(n) * fatorial(m - n)));
    }

    // Função para calcular a quantidade de permutações possíveis
    private static int permutacoes(int m, int n) {
        return (fatorial(m) / fatorial(m - n));
    }

}
