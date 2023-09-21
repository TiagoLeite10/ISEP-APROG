import java.util.Scanner;

// E - Estatísticas de vencimentos
public class E {

    private static final Scanner read = new Scanner(System.in);
    private static final int MAX_EMPLOYEES = 20;

    public static void main(String[] args) {

        String[] employeesNames = new String[MAX_EMPLOYEES];
        double[] employeesSalary = new double[MAX_EMPLOYEES];
        int totalEmployees = readEmployeesData(employeesNames, employeesSalary);
        showData(calculateSalaryAverage(employeesSalary, totalEmployees), employeesSalary, employeesNames, totalEmployees);

    }

    // Função para ler os dados (nomes e vencimento) dos funcionários da empresa e retornar o número de funcionários existentes
    private static int readEmployeesData(String[] employeesNames, double[] employeesSalary) {

        int numberOfEmployees = 0;
        String name;

        do {

            name = read.nextLine();
            employeesNames[numberOfEmployees] = name;
            if (!name.equals("fim")) {
                employeesSalary[numberOfEmployees] = read.nextDouble();
                numberOfEmployees++;
                read.nextLine();
            }

        } while (!name.equals("fim") || numberOfEmployees >= MAX_EMPLOYEES);

        return numberOfEmployees;

    }

    // Função para calcular o vencimento médio dos funcionários
    private static double calculateSalaryAverage(double[] employeesSalary, int numberOfEmployees) {

        double average = 0;

        for (int person = 0; person < numberOfEmployees; person++) {
            average += employeesSalary[person];
        }

        return average / numberOfEmployees;

    }

    // Procedimento para mostrar os resultados obtidos
    private static void showData(double salaryAverage, double[] employeesSalary, String[] employeesNames, int totalEmployees) {

        System.out.printf("%.1f%n", salaryAverage);

        for (int employee = 0; employee < totalEmployees; employee++) {
            if (employeesSalary[employee] < salaryAverage) {
                System.out.println(employeesNames[employee]);
            }
        }

    }

}
