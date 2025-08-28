package utn.frc.bda.semana1.ejercicio1.ejercicio5;

import java.util.Scanner;

public class Estadisiticas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int notaMaxima = Integer.MIN_VALUE;
        int notaMinima = Integer.MAX_VALUE;
        int sumaNotas = 0;
        int cantNotas = 0;
        int aprobados = 0;
        int desaprobados = 0;

        System.out.println("Ingrese notas entre 0 y 10, finaliza con -1: ");

        while (true) {
            System.out.print("Nota: ");
            try {
                int nota = sc.nextInt();
                //veo si quiere finalizar o o
                if (nota == -1) {
                    break;
                }
                // validar que este en el rango permitido
                if (nota < 0 || nota > 10) {
                    System.out.println("Nota invalida!");
                    continue;
                }
                // Procesamos nota valida
                cantNotas++;
                sumaNotas += nota;
                // actulizo nota max
                if (nota > notaMaxima) {
                    notaMaxima = nota;
                }
                // actulizo nota min
                if (nota < notaMinima) {
                    notaMinima = nota;
                }
                // contar aprobaods y desaprobados
                if (nota >= 6) {
                    aprobados++;
                } else {
                    desaprobados++;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
        // Mostrar resulatdos
        if (cantNotas == 0) {
            System.out.println("No hay notas entre 0 y 10");
        } else {
            double promedio = (double) sumaNotas/cantNotas;

            System.out.println("\n=== ESTADÍSTICAS DE NOTAS ===");
            System.out.println("Cantidad de notas procesadas: " + cantNotas);
            System.out.println("Nota máxima: " + notaMaxima);
            System.out.println("Nota mínima: " + notaMinima);
            System.out.printf("Promedio: %.2f\n", promedio);
            System.out.println("Cantidad de aprobados (≥ 6): " + aprobados);
            System.out.println("Cantidad de desaprobados (< 6): " + desaprobados);
        }
    }
}
