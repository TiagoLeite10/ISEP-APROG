import java.util.Scanner;

// X - Relógio
public class X {

    public static void main(String[] args) {

        Scanner read = new Scanner(System.in);
        int brandCode;

        brandCode = read.nextInt();

        switch (brandCode) {
            case 1:
                System.out.println("Tag Heuer");
                break;
            case 2:
                System.out.println("Rolex");
                break;
            case 3:
                System.out.println("Omega");
                break;
            case 4:
                System.out.println("Cartier");
                break;
            case 5:
                System.out.println("Bvlgari");
                break;
            case 6:
                System.out.println("Raymond Weil");
                break;
            default:
                System.out.println("Marca invalida");
                break;
        }

    }

}
