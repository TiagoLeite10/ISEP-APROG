import java.util.Scanner;

// J - Top 3
public class J {

    private static final Scanner read = new Scanner(System.in);
    private static final int MAX_EMPLOYEES = 100;
    private static final int TOP = 3;
    private static final String END_WORD = "FIM";

    public static void main(String[] args) {

        String[] employeesName = new String[MAX_EMPLOYEES];
        int[] employeesSalary = new int[MAX_EMPLOYEES];
        readEmployeesData(employeesName, employeesSalary);
        calculateHighestPaidEmployees(employeesName, employeesSalary);

    }

    // Procedimento para ler os dados sobre os funcionários (nome e salário)
    private static void readEmployeesData(String[] employeesName, int[] employeesSalary) {

        int numberEmployees = 0;
        boolean endWordTrigger = false;

        do {

            employeesName[numberEmployees] = read.nextLine();

            if (!employeesName[numberEmployees].equals(END_WORD)) {
                employeesSalary[numberEmployees] = read.nextInt();
                read.nextLine();
                numberEmployees++;
            } else {
                endWordTrigger = true;
            }

        } while (!endWordTrigger && numberEmployees < MAX_EMPLOYEES);

    }

    // Procedimento para verificar quais são os funcionários com os maiores salários (Top 3)
    private static void calculateHighestPaidEmployees(String[] employeesName, int[] employeesSalary) {

        String[] highestPaidEmployeesName = new String[TOP];
        int[] highestPaidEmployeesSalary = new int[TOP];
        int topPlace;
        boolean foundBetterPlace;
        int numberEmployee = 0;
        int numberOfTopSalary = 0;

        while (! employeesName[numberEmployee].equals(END_WORD)) {
            topPlace = 0;
            foundBetterPlace = false;
            while (topPlace < TOP && ! foundBetterPlace) {
                if (highestPaidEmployeesSalary[topPlace] <= employeesSalary[numberEmployee]) {
                    numberOfTopSalary++;
                    for (int i = TOP - 1; i >= topPlace; i--) {
                        if (topPlace == i) {
                            highestPaidEmployeesName[i] = employeesName[numberEmployee];
                            highestPaidEmployeesSalary[i] = employeesSalary[numberEmployee];
                        } else {
                            highestPaidEmployeesName[i] = highestPaidEmployeesName[i - 1];
                            highestPaidEmployeesSalary[i] = highestPaidEmployeesSalary[i - 1];
                        }
                    }
                    foundBetterPlace = true;
                }
                topPlace++;
            }

            numberEmployee++;
        }

        if (numberOfTopSalary > 3) {
            numberOfTopSalary = 3;
        }

        orderHighestSalaryEmployees(highestPaidEmployeesName, highestPaidEmployeesSalary, numberOfTopSalary);
        printHighestSalaryEmployeesData(highestPaidEmployeesName, highestPaidEmployeesSalary, numberOfTopSalary);

    }

    private static void orderHighestSalaryEmployees(String[] nameHighestSalaryEmployees, int[] highestPaidEmployeesSalary, int numberOfTopSalary) {

        for (int mainTerm = 0; mainTerm < numberOfTopSalary - 1; mainTerm++) {
            for (int secondTerm = mainTerm; secondTerm < numberOfTopSalary; secondTerm++) {
                if (highestPaidEmployeesSalary[mainTerm] == highestPaidEmployeesSalary[secondTerm]) {

                    String tempName;

                    if (nameHighestSalaryEmployees[mainTerm].compareTo(nameHighestSalaryEmployees[secondTerm]) > 0) {
                        tempName = nameHighestSalaryEmployees[mainTerm];
                        nameHighestSalaryEmployees[mainTerm] = nameHighestSalaryEmployees[secondTerm];
                        nameHighestSalaryEmployees[secondTerm] = tempName;
                    }

                }
            }
        }

    }

    // Procedimento para imprimir os dados acerca dos funcionários com os salários mais altos
    private static void printHighestSalaryEmployeesData(String[] nameHighestSalaryEmployees, int[] salaryHighestSalaryEmployees, int numberOfTopSalary) {

        for (int employee = 0; employee < numberOfTopSalary; employee++) {
            System.out.println("#" + (employee + 1) + ":" + nameHighestSalaryEmployees[employee] + ":" + salaryHighestSalaryEmployees[employee]);
        }

    }

}
