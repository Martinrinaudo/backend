package utn.frc.bda.semana2.apunte6;

import java.util.Scanner;

public class arreglo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v[];
        v = new int[6];
        for (int i = 0; i < v.length; i++)
        {
            System.out.println("Ingrese v["+i+"]: ");
            v[i] = sc.nextInt();
        }
        for (int i = 0; i < v.length; i++)
        {
            System.out.println(v[i]);
        }
    }
}
