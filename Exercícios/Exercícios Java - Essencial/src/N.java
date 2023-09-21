import java.util.Scanner;

// N - Sequências crescentes
public class N {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        int number, lastNumber = 0;
        int tempNumber, digit, lastDigit = 9;
        boolean hasTwoNumbers = false;
        boolean growingNumber = true;

        number = read.nextInt();
        while (number >= 0) {

            // Saber quando já existem dois números introduzidos
            if (hasTwoNumbers) {

                // Se o número for maior do que o número introduzido anteriormente
                if (number > lastNumber) {

                    tempNumber = number;
                    boolean firstIteration = true;
                    while (tempNumber > 0 && growingNumber) {
                        digit = tempNumber % 10;

                        // Se for a primeira iteração, não se compara o digito anterior com o atual, pois ainda
                        //não foi guardado nenhum digito deste número
                        if (firstIteration) {
                            firstIteration = false;
                        } else if (lastDigit <= digit) {
                            // Se o último digito mais á direita for sempre maior do que o digito mais
                            //à direita atual, então o número está ordenado
                            growingNumber = false;
                        }

                        // Saber o último digito mais à direita
                        lastDigit = digit;

                        tempNumber /= 10;
                    }

                    // Como aqui já sabemos de o número é maior do que o anterior,
                    //apenas é preciso verificar se os seus algarismos estão por ordem crescente
                    if (growingNumber) {
                        System.out.println(number);
                    }

                }

            } else {
                hasTwoNumbers = true;
            }

            // Como sabemos que o maior digito possível é 9, para não dar problemas na primeira verificação
            //lastDigit = 9;
            growingNumber = true;
            lastNumber = number;
            number = read.nextInt();
        }

    }

}
