package utn.frc.bda.clase2808;

public class arreglos {

    // declaro
    int [] v;


    public arreglos () {
        // creacion
        v = new int[10];
    }
    public void mostrarArreglo() {
        for (int i = 0; i < v.length; i++) {
            System.out.println("v[" + i + "] = " + v[i]);
        }
    }

    public static void main(String[] args) {
        arreglos miArreglo = new arreglos();
        miArreglo.mostrarArreglo();
    }

}
