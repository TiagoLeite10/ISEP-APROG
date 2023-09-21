import java.util.Scanner;

// I - Elemento de Fibonacci
public class I {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int number = read.nextInt();
        isFibonacci(isNumberOnFibonacciElements(number));

    }

    // Procedimento para informar se é ou não número de fibonacci
    private static void isFibonacci(boolean isOnFibonacciElements) {

        if (isOnFibonacciElements) {
            System.out.println("e de Fibonacci");
        } else {
            System.out.println("nao e de Fibonacci");
        }

    }

    // Função para verificar se um número pertence à sucessão de Fibonacci ou não
    private static boolean isNumberOnFibonacciElements(int number) {

        int fibonacciLastNumber = 0, fibonacciNextNumber = 0, borrowedNumber;

        while (fibonacciNextNumber < number) {

            borrowedNumber = fibonacciNextNumber;
            fibonacciNextNumber += fibonacciLastNumber;
            fibonacciLastNumber = borrowedNumber;

            if (fibonacciNextNumber == 0) {
                fibonacciNextNumber = 1;
            }

        }

        return number == fibonacciNextNumber;

    }

}
