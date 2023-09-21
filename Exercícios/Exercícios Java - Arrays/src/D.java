import java.util.Scanner;

// D - Frequências das notas
public class D {

    private static Scanner read = new Scanner(System.in);
    private static final int NUMBER_GRADES = 21;

    public static void main(String[] args) {

        int numberOfGrades = read.nextInt();

        int[] grades = readAndStoreData(numberOfGrades);
        int[] countNotesFrequencies = determineNoteFrequencies(grades);
        showFrequenciesNotes(countNotesFrequencies);

    }

    // Função para ler e armazenar as notas dos alunos
    private static int[] readAndStoreData(int numberOfGrades) {

        int[] grades = new int[numberOfGrades];
        int grade;

        for (int numGrade = 0; numGrade < numberOfGrades; numGrade++) {
            grade = read.nextInt();
            grades[numGrade] = grade;
        }

        return grades;

    }

    // Função para determinar as frequências das notas (zero a vinte)
    private static int[] determineNoteFrequencies(int[] grades) {

        int[] countNotesFrequencies = new int[NUMBER_GRADES];

        for (int grade = 0; grade < grades.length; grade++) {
            countNotesFrequencies[grades[grade]]++;
        }

        return countNotesFrequencies;

    }

    // Procedimento para mostrar os valores das frequências
    private static void showFrequenciesNotes(int[] countNotesFrequencies) {

        for (int grade = 0; grade < countNotesFrequencies.length; grade++) {
            System.out.println(grade + " " + countNotesFrequencies[grade]);
        }

    }

}
