package utn.frc.bda.semana2.cafeteria;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una cafetera inicial
        Cafeteria cafetera = new Cafeteria("Philips", "SmartBrew", 1000, 0, false, 0, 20);

        int opcion;

        do {
            System.out.println("\n--- MENÚ CAFETERA INTELIGENTE ☕ ---");
            System.out.println("1. Encender cafetera");
            System.out.println("2. Apagar cafetera");
            System.out.println("3. Cargar agua");
            System.out.println("4. Calentar");
            System.out.println("5. Servir café");
            System.out.println("6. Mostrar estado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    cafetera.encender();
                    System.out.println(" Cafetera encendida.");
                    break;
                case 2:
                    cafetera.apagar();
                    System.out.println("Cafetera apagada.");
                    break;
                case 3:
                    System.out.print("¿Cuántos ml de agua desea cargar?: ");
                    int agua = scanner.nextInt();
                    cafetera.cargarAgua(agua);
                    System.out.println("Agua cargada.");
                    break;
                case 4:
                    cafetera.calentar();
                    System.out.println("Cafetera calentando...");
                    break;
                case 5:
                    boolean servido = cafetera.servirCafe();
                    if (servido) {
                        System.out.println("Café servido.");
                    } else {
                        System.out.println(" No se pudo servir el café. Verifique agua y temperatura.");
                    }
                    break;
                case 6:
                    System.out.println(" Estado actual de la cafetera:");
                    System.out.println(cafetera);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println(" Opción inválida.");
            }

        } while (opcion != 0);

        scanner.close();
    }
}

