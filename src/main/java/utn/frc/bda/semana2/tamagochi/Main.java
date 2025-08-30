package utn.frc.bda.semana2.tamagochi;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MascotaVirtual mascota = new MascotaVirtual("Martin", 50, 4, false, true);

        int opc;
        do {
            System.out.println("\n--- TAMAGOCHI ---");
            System.out.println("1. Comer");
            System.out.println("2. Beber");
            System.out.println("3. Correr");
            System.out.println("4. Saltar");
            System.out.println("5. Dormir");
            System.out.println("6. Despertar");
            System.out.println("7. Mostrar estado");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opc = scanner.nextInt();

            switch (opc) {
                case 1 -> mascota.comer();
                case 2 -> mascota.beber();
                case 3 -> mascota.correr();
                case 4 -> mascota.saltar();
                case 5 -> mascota.dormir();
                case 6 -> mascota.despertar();
                case 7 -> System.out.println(mascota);
                case 0 -> System.out.println("👋 Saliendo del programa...");
                default -> System.out.println("❌ Opción inválida.");
            }

            System.out.println(mascota);

        } while (opc != 0);
    }
}

