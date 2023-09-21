import java.util.Scanner;

// I - Condomínio
public class I {

    private static final int ENTRY = 3;
    private static final int FLOORS = 4;
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {

        String[][] residence = readApartmentOwnerName();
        String ownerName = read.nextLine();
        if (! showOwnerData(ownerName, residence)) {
            System.out.println("Nao mora no predio");
        }

    }

    // Função para ler o nome do proprietário de cada apartamento
    private static String[][] readApartmentOwnerName() {

        String[][] residence = new String[ENTRY][FLOORS];

        for (int entry = 0; entry < ENTRY; entry++) {
            for (int floor = 0; floor < FLOORS; floor++) {
                residence[entry][floor] = read.nextLine();
            }
        }

        return residence;

    }

    // Procedimento em que dado um nome de um proprietário, é procurada e impressa a informação acerca da entrada e piso do seu apartamento
    private static boolean showOwnerData(String ownerName, String[][] residenceOwners) {

        boolean foundOwner = false;

        for (int entry = 0; entry < ENTRY; entry++) {
            for (int floor = 0; floor < FLOORS; floor++) {
                if (residenceOwners[entry][floor].equals(ownerName)) {
                    System.out.println("nome=" + residenceOwners[entry][floor]);
                    System.out.println("entrada=" + entry);
                    System.out.println("piso=" + floor);
                    foundOwner = true;
                }
            }
        }

        return foundOwner;

    }

}
