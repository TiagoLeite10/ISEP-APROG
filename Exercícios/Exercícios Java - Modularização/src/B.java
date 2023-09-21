import java.util.Scanner;

// B - Gráfico de classificações
public class B {

    private final static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        int numStudents, numSubjects;

        numStudents = read.nextInt();
        numSubjects = read.nextInt();

        for (int subject = 0; subject < numSubjects; subject++) {

            read.nextLine();
            String subjectName = read.nextLine();
            int approvedStudents = read.nextInt();
            printInformation(subjectName, approvedStudents, numStudents);

        }

    }

    // Procedimento para imprimir a informação acerca de uma disciplina
    private static void printInformation(String subjectName, int approvedStudents, int numStudents) {

        System.out.println("Disciplina: " + subjectName);
        System.out.println("- Positivas: " + fillString('*', approvedStudents));
        System.out.println("- Negativas: " + fillString('*', numStudents - approvedStudents));

    }

    private static String fillString(char c, int number) {

        String string = "";

        for (int i = 1; i <= number; i++) {
            string += c;
        }

        return string;

    }

}
