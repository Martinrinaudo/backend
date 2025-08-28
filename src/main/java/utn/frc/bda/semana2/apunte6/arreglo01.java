package utn.frc.bda.semana2.apunte6;

import java.util.Scanner;

public class arreglo01 {
    public static void main(String[] args) {
        int v[];
        v = new int[6];
        Scanner sc = new Scanner(System.in);
        v[3] = 4;
        v[1]++;
        System.out.println(v[0]);
        v[4] = v[1] - v[0];
        v[5] = sc.nextInt();
        v[2] = v[2] - 8;
        System.out.println(v[1]);
        System.out.println(v[2]);
        System.out.println(v[3]);
        System.out.println(v[4]);
        System.out.println(v[5]);
    }
}
