import java.util.Scanner;

// M - Sequência de Fibonacci
public class M {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int numberOfTerms, antePenultimateNumber = 0, penultimateNumber = 1;

        numberOfTerms = read.nextInt();

        if (numberOfTerms == 1) {
            System.out.println(0);
        } else if (numberOfTerms == 2) {
            System.out.println(0);
            System.out.println(1);
        } else if (numberOfTerms > 2) {
            System.out.println(0);
            System.out.println(1);
            int sum = 0;
            for (int term = 3; term <= numberOfTerms; term++) {

                sum = antePenultimateNumber + penultimateNumber;
                System.out.println(sum);
                antePenultimateNumber = penultimateNumber;
                penultimateNumber = sum;

            }

        }

    }

}
