import java.util.Scanner;

// C - Calcular ângulos de um triângulo
public class C {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);

        double sideA, sideB, sideC;
        sideA = read.nextDouble();
        sideB = read.nextDouble();
        sideC = read.nextDouble();

        boolean possibleTriangle = (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
        printResults(possibleTriangle, sideA, sideB, sideC);

    }

    // Função para calcular um ângulo interno de um triângulo
    private static double calculateAngle(double side1, double side2, double side3) {

        double calculatedAngle;

        calculatedAngle = Math.acos((Math.pow(side1, 2) + Math.pow(side2, 2) - Math.pow(side3, 2)) / (2 * side1 * side2));

        return calculatedAngle;

    }

    // Procedimento para imprimir os resultados
    private static void printResults(boolean possibleTriangle, double sideA, double sideB, double sideC) {

        if (possibleTriangle) {
            System.out.print("a=");
            System.out.printf("%.2f\n", sideA);
            System.out.print("b=");
            System.out.printf("%.2f\n", sideB);
            System.out.print("c=");
            System.out.printf("%.2f\n", sideC);
            System.out.print("ang(a,b)=");
            System.out.printf("%.2f\n", Math.toDegrees(calculateAngle(sideA, sideB, sideC)));
            System.out.print("ang(a,c)=");
            System.out.printf("%.2f\n", Math.toDegrees(calculateAngle(sideA, sideC, sideB)));
            System.out.print("ang(b,c)=");
            System.out.printf("%.2f\n", Math.toDegrees(calculateAngle(sideB, sideC, sideA)));
        } else {
            System.out.println("impossivel");
        }

    }

}
