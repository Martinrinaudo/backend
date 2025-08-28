package utn.frc.bda.semana1.ejercicio1.ejercicio2;

import java.util.Scanner;

public class ISBN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //aca le pido que ingrese el isbn

        String isbn = sc.nextLine();
        System.out.println(esISBNValido(isbn));
    }
    public static boolean esISBNValido(String isbn) {
        String limpio = isbn.replace("-","");
        if(limpio.length()!=10){
            return false;
        }
        int suma = 0;
        for (int i = 0; i < 10; i++) {
            char ch = limpio.charAt(i);
            int valor;

            if (i == 9 && ch == 'X') {
                valor = 10;
            } else if (Character.isDigit(ch)) {
                valor = ch - '0';
            } else {
                return false; //caracter invalido
            }
            suma += valor * (10 - i);
        }
        return suma % 11 == 0;
    }
}
