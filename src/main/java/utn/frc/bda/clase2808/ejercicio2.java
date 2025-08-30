package utn.frc.bda.clase2808;

import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear arreglo de 5 personas
        Persona[] personas = new Persona[2];

        // Cargar los datos de las personas por teclado
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Ingrese los datos de la persona " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = sc.nextLine();

            System.out.print("Edad: ");
            int edad = sc.nextInt();

            System.out.print("Documento: ");
            int documento = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer del Scanner

            // Crear la persona y agregarla al arreglo
            personas[i] = new Persona(nombre, edad, documento);
        }

        // Mostrar lista de todas las personas
        System.out.println("\nLista de todas las personas:");
        for (Persona persona : personas) {
            System.out.println(persona);  // Imprime automáticamente el toString()
        }

        // Calcular el promedio de edades y encontrar la persona con la mayor edad
        double sumaEdades = 0;
        int maxEdad = Integer.MIN_VALUE;
        String nombreMayorEdad = "";

        for (Persona persona : personas) {
            sumaEdades += persona.getEdad();

            if (persona.getEdad() > maxEdad) {
                maxEdad = persona.getEdad();
                nombreMayorEdad = persona.getNombre();
            }
        }

        double promedioEdad = sumaEdades / personas.length;

        // Mostrar los resultados
        System.out.println("\nPromedio de edades: " + promedioEdad);
        System.out.println("La persona con la mayor edad es: " + nombreMayorEdad);
    }
}
