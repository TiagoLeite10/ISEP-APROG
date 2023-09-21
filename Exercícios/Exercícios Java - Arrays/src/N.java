import java.util.Scanner;

// N - Diagonais
public class N {

    private static final Scanner read = new Scanner(System.in);
    private static final int MIN_SIZE = 2;
    private static final int MAX_SIZE = 20;

    public static void main(String[] args) {

        int size = readMatrixSize();
        int[][] matrix = new int[size][size];
        readMatrixValues(matrix);
        printUpAndMainDiagonalNumbers(matrix);
        printDownMainDiagonalNumbers(matrix);
    }

    // Função para ler a dimensão da matriz
    private static int readMatrixSize() {

        int size;

        do {
            size = read.nextInt();
        } while (size < MIN_SIZE || size > MAX_SIZE);

        return size;

    }

    // Procedimento para ler os valores para cada posição da matriz
    private static void readMatrixValues(int[][] matrix) {

        for (int line = 0; line < matrix.length; line++) {
            for (int column = 0; column < matrix[line].length; column++) {
                matrix[line][column] = read.nextInt();
            }
        }

    }

    // Procedimento para imprimir as diagonais acima da diagonal principal (mais à direita), e também a diagonal principal
    private static void printUpAndMainDiagonalNumbers(int[][] matrix) {

        int column = matrix.length - 1;

        do {

            for (int line = 0; line < matrix.length; line++) {
                if (column + line < matrix.length) {
                    System.out.print("[" + matrix[line][column + line] + "]");
                }
            }

            System.out.println();
            column--;

        } while (column >= 0);

    }

    // Procedimento para imprimir as diagonais abaixo da diagonal principal (mais à esquerda)
    private static void printDownMainDiagonalNumbers(int[][] matrix) {

        int column;
        int line = 1;

        do {
            column = 0;
            for (int tempLine = line; tempLine < matrix.length; tempLine++) {
                System.out.print("[" + matrix[tempLine][column] + "]");
                column++;
            }
            line++;
            System.out.println();
        } while (line < matrix.length);

    }

}
