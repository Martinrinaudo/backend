package utn.frc.bda.clase2808;

public class ejercicio1 {
    public static void main(String[] arg) {

        int[] numero = new int[20];

        for (int i = 0; i < numero.length; i++) {
            numero[i] = (int) (Math.random() * 201) - 100;
        }
        System.out.println("Numeros generado");
        for(int i = 0; i < numero.length; i++) {
            System.out.println(numero[i] + " ");
        }

        int suma = 0;
        int cantNeg = 0;
        int mayor = Integer.MIN_VALUE;


        for (int i = 0; i < numero.length; i++) {
            int num = numero[i];
            suma += num;
            if (num < 0) {
                cantNeg++;
            }
            if (num > mayor) {
                mayor = num;
            }
        }
        double promedio = (double) suma / numero.length;

        System.out.println("Promedio: " + promedio);
        System.out.println("Cant de negativos: " + cantNeg);
        System.out.println("Mayor numero: " + mayor);
    }

}
