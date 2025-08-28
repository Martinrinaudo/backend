package utn.frc.bda.semana1.ejercicio1;

import javax.swing.*;
import java.net.SocketOption;

public class CicloFor {
    public static void main(String[] args) {
        int f = 4;
        int f2 = 5;
        int c = 6;
        char a = '*';
        char e = ' ';
        int maxAsteriscos = 5;
        //figura 1
        for (int i = 0; i < f; i++) {
            if (i % 2 !=0 ) {
                System.out.print(e);
            }
            for (int j = 0; j < c; j++) {
                System.out.print(a);
                if (j < c - 1) {
                    System.out.print(e);
                }
            }
            System.out.println();
        }
        System.out.println("Ascendente");
        for (int i = 1; i <= maxAsteriscos; i++) {
            for ( int j = 0; j < i; j++){
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println("Descendente");
        for (int i = maxAsteriscos - 1; i >= 1; i--) {
            for ( int j = 0; j < i; j++){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}
