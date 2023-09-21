import java.util.Scanner;

// O - Pizza
public class O {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int allergyIngredientsOriginal, numberOfPizzas, digit, allergyIngredientsTemp, suggestion = 1;
        int numberPizzaOriginal, numberPizzaTemp, allergyIngredientDigit;
        boolean foundAllergyIngredient;

        allergyIngredientsOriginal = read.nextInt();

        numberOfPizzas = read.nextInt();

        for (int menu = 1; menu <= numberOfPizzas; menu++) {

            numberPizzaOriginal = read.nextInt();

            numberPizzaTemp = numberPizzaOriginal;
            foundAllergyIngredient = false;

            while (numberPizzaTemp > 0 && !foundAllergyIngredient) {

                allergyIngredientsTemp = allergyIngredientsOriginal;
                digit = numberPizzaTemp % 10;

                while (allergyIngredientsTemp > 0 && !foundAllergyIngredient) {

                    allergyIngredientDigit = allergyIngredientsTemp % 10;

                    if (digit == allergyIngredientDigit) {
                        foundAllergyIngredient = true;
                    }

                    allergyIngredientsTemp /= 10;

                }

                numberPizzaTemp /= 10;

            }

            if (!foundAllergyIngredient) {
                System.out.println("Sugestao #" + suggestion + ":" + numberPizzaOriginal);
                suggestion++;
            }

        }

    }

}
