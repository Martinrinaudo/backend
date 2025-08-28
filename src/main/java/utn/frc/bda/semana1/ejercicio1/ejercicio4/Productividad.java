package utn.frc.bda.semana1.ejercicio1.ejercicio4;

import java.util.Scanner;

public class Productividad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //pedir nombre
        System.out.println("Ingrese su nombre");
        String nombre = sc.nextLine();
        // pedir horas
        int horas;
        while (true) {
            System.out.println("Ingrese su horas");
            String entrada = sc.nextLine();
            try {
                horas = Integer.parseInt(entrada);
                break; // salir si la conversion fue exitosa
            } catch (NumberFormatException e) {
                System.out.println("Ingrese su horas y que sea un entero");
            }
        }
        // peidr hora trabajas
        int tareas;
        while (true) {
            System.out.println("Ingrese cant de tareas");
            String entrada = sc.nextLine();
            try {
                tareas = Integer.parseInt(entrada);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese sus tareas y que sea un entero");
            }
        }
        // Calculo indice de productivodad
        int indiceProd;
        if (tareas < 8) {
            indiceProd = (tareas * 10) - (5 * (8 - horas));
        } else {
            indiceProd = (tareas * 10) + 5;
        }
        // Mostrar resumen
        System.out.println("Resumen de empleado");
        System.out.println("Nombre: " + nombre);
        System.out.println("Horas: " + horas);
        System.out.println("Tareas: " + tareas);
        System.out.println("El productividad es: " + indiceProd);
    }
}
