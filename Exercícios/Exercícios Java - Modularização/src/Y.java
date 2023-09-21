import java.util.Scanner;

// Y - Tabuadas de um intervalo
public class Y {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        int limiteUm, limiteDois;
        limiteUm = lerValorInteiroPositivo();
        limiteDois = lerValorInteiroPositivo();

        mostrarTabuadasDoIntervalo(limiteUm, limiteDois);

    }

    // Função para ler um valor inteiro e positivo
    private static int lerValorInteiroPositivo() {

        int numero;

        do {
            numero = read.nextInt();
        } while  (numero <= 0);

        return numero;

    }

    // Procedimento para mostrar a tabuada de cada número presente num dado intervalo de números
    private static void mostrarTabuadasDoIntervalo(int limiteInferior, int limiteSuperior) {

        if (limiteInferior > limiteSuperior) {
            int numeroTemporario = limiteInferior;
            limiteInferior = limiteSuperior;
            limiteSuperior = numeroTemporario;
        }

        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            mostrarTabuadaDoNumero(i);
        }

    }

    // Procedimento para mostrar a tabuada de um dado número
    private static void mostrarTabuadaDoNumero(int numero) {
        System.out.println("Tabuada de " + numero);
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + numero * i);
        }
    }

}
