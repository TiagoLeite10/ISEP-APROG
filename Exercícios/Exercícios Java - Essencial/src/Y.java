import java.util.Scanner;

// Y - Divisores múltiplos de 3
public class Y {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int number;
        boolean hasDividersBy3 = false;

        do {
            number = read.nextInt();
        } while (number < 1);

        for (int numberMultipleOf3 = 3; numberMultipleOf3 <= (number / 2); numberMultipleOf3 += 3) {

            if (number % numberMultipleOf3 == 0) {
                hasDividersBy3 = true;
                System.out.println(numberMultipleOf3);
            }

        }

        if (! hasDividersBy3) {
            System.out.println("sem divisores multiplos de 3");
        }

    }

}
