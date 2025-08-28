package utn.frc.bda.semana2.apunte6;
import java.util.Scanner;
public class MainAscensor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ascensor ascensor = new ascensor(5); // capacidad máxima 5 personas
        int opcion;

        do {
            System.out.println("\n===== MENU ASCENSOR =====");
            System.out.println("1. Ir a un piso");
            System.out.println("2. Subir personas");
            System.out.println("3. Bajar personas");
            System.out.println("4. Ver estado del ascensor");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el piso destino (-2 a 10): ");
                    int piso = sc.nextInt();
                    if (ascensor.irAPiso(piso)) {
                        System.out.println("Ascensor movido al piso " + piso);
                    } else {
                        System.out.println(" Piso inválido. Solo entre -2 y 10.");
                    }
                    break;

                case 2:
                    System.out.print("¿Cuántas personas quieren subir?: ");
                    int suben = sc.nextInt();
                    int efectivasSuben = ascensor.subirPersonas(suben);
                    System.out.println("Subieron " + efectivasSuben + " personas.");
                    break;

                case 3:
                    System.out.print("¿Cuántas personas quieren bajar?: ");
                    int bajan = sc.nextInt();
                    int efectivasBajan = ascensor.bajarPersonas(bajan);
                    System.out.println("Bajaron " + efectivasBajan + " personas.");
                    break;

                case 4:
                    System.out.println(ascensor); // usa toString()
                    break;

                case 0:
                    System.out.println(" Saliendo del programa...");
                    break;

                default:
                    System.out.println(" Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();

    }
}
