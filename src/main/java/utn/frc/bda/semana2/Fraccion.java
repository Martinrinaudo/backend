package utn.frc.bda.semana2;

import lombok.Data;
import lombok.NonNull;

@Data

public class Fraccion {
    public static void main(String[] args) {
        // Declaro una referencia a Fraccion
        Fraccion f1 = null;
        Fraccion f2 = new Fraccion(3,4);
        System.out.println(f1);
        System.out.println(f2);

        f1 = new Fraccion(1, 3);
        System.out.println(f1);
        System.out.println(f1.valorReal());

        Fraccion suma = f1.sumar(f2);
        System.out.println("Suma" + suma);

        System.out.println("fin");
    }
    // atributos
    private int numerador;
    private int denominador;

    //constructores
    public Fraccion(int numerador, @NonNull int denominador) {
        if (denominador == 0) {
            throw new ArithmeticException("EL denominador no puede ser 0");
        }
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    public double valorReal()
    {
        return (double) numerador / denominador;
    }
    private int mcd (int a, int b) {
        return b == 0 ? a : mcd(b, a % b);
    }
    private void simplificar() {
        int divisor = mcd(Math.abs(numerador), Math.abs(denominador));
        numerador /= divisor;
        denominador /= divisor;
    }
    public Fraccion sumar(Fraccion otra) {
        return new Fraccion(
                this.numerador * otra.denominador + otra.numerador * this.denominador,
                this.denominador * otra.denominador);
    }
    public Fraccion restar(Fraccion otra) {
        return new Fraccion(
                this.numerador * otra.denominador - otra.numerador * this.denominador,
                this.denominador * otra.denominador);
    }
    public Fraccion multiplicar(Fraccion otra) {
        return new Fraccion(
                this.numerador * otra.numerador,
                this.denominador * otra.denominador);
    }
    public Fraccion dividir(Fraccion otra) {
        if (otra.numerador == 0) {
            throw new ArithmeticException("No se puede dividir por una fracción con numerador cero");
        }
        return new Fraccion(
                this.numerador * otra.denominador,
                this.denominador * otra.numerador);
    }

}
