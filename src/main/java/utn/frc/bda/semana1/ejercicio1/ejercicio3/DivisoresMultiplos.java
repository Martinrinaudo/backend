package utn.frc.bda.semana1.ejercicio1.ejercicio3;

import java.util.Scanner;

public class DivisoresMultiplos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el primer numero: ");
        int num = sc.nextInt();
        if (esValido(num)) {
            mostrarMultiplos(num);
        } else {
            System.out.println("El primer numero no es valido");
        }
    }
    public static boolean esValido(int num) {
        return num > 0;
    }
    public static void mostrarMultiplos(int num) {

        for (int i = 1; i <= num; i++) {
            if ((i % 3 == 0 && i % 5 != 0) || (i % 5 == 0 && i % 3 != 0)) {
                System.out.println(i);
            }
        }

    }
}
