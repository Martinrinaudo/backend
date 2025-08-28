package utn.frc.bda.semana1.ejercicio1.ejercicio6;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class archivoTxtx {
    public static void main(String[] args) {
        String nombreArchivo = "numeros.txt";
        int cantidadNumeros = 0;
        int cantidadLineasNoValidas = 0;
        int cantidadPares = 0;
        int cantidadImpares = 0;
        int sumaNumeros = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                try {
                    int numero = Integer.parseInt(linea.trim());
                    cantidadNumeros++;
                    sumaNumeros += numero;

                    if (numero % 2 == 0) {
                        cantidadPares++;
                    } else {
                        cantidadImpares++;
                    }
                } catch (NumberFormatException e) {
                    cantidadLineasNoValidas++;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo " + nombreArchivo + " no existe.");
            return; // Salir del programa si el archivo no se encuentra
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return; // Salir del programa si hay un error de lectura
        }

        // Calcular el promedio
        double promedio = cantidadNumeros > 0 ? (double) sumaNumeros / cantidadNumeros : 0;

        // Mostrar resultados
        System.out.println("Cantidad total de números leídos: " + cantidadNumeros);
        System.out.println("Cantidad total de líneas no válidas: " + cantidadLineasNoValidas);
        System.out.println("Cantidad de números pares: " + cantidadPares);
        System.out.println("Cantidad de números impares: " + cantidadImpares);
        System.out.printf("Promedio de todos los números: %.2f\n", promedio);
    }
}
