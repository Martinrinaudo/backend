package utn.frc.bda.semana2.tamagochi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MascotaVirtual {
    private int energia;
    private int humor;
    private String nombre;
    private boolean duerme;
    private boolean vive;
    private int contIngestas;
    private int contActividades;

    // Constructor
    public MascotaVirtual(String nombre, int energia, int humor, boolean duerme, boolean vive) {
        this.nombre = nombre;
        this.energia = energia;
        this.humor = humor;
        this.duerme = duerme;
        this.vive = vive;
    }

    private void muere(String causa) {
        vive = false;
        duerme = false;
        System.out.println("💀 La mascota ha muerto por " + causa + ".");
    }

    private void controlarLimites() {
        if (energia > 100) energia = 100;
        if (energia <= 0) muere("cansancio");

        if (humor > 5) humor = 5;
        if (humor <= 0) {
            humor = 1;
            duerme = true;
            System.out.println("😴 La mascota se fue a dormir de enojada.");
        }
    }

    public boolean comer() {
        if (!vive || duerme) return false;
        contIngestas++;
        contActividades = 0;

        if (contIngestas == 5) {
            muere("empacho");
            return false;
        }

        energia += (int)(energia * 0.1);
        if (contIngestas >= 3) {
            humor -= 1;
        } else {
            humor += 1;
        }

        controlarLimites();
        return true;
    }

    public boolean beber() {
        if (!vive || duerme) return false;
        contIngestas++;
        contActividades = 0;

        if (contIngestas == 5) {
            muere("empacho");
            return false;
        }

        energia += (int)(energia * 0.05);
        if (contIngestas >= 3) {
            humor -= 1;
        } else {
            humor += 1;
        }

        controlarLimites();
        return true;
    }

    public boolean correr() {
        if (!vive || duerme) return false;
        contActividades++;
        contIngestas = 0;

        energia -= (int)(energia * 0.35);
        humor -= 2;

        if (contActividades == 3) {
            duerme = true;
            System.out.println("😴 La mascota se empacó y se fue a dormir.");
        }

        controlarLimites();
        return true;
    }

    public boolean saltar() {
        if (!vive || duerme) return false;
        contActividades++;
        contIngestas = 0;

        energia -= (int)(energia * 0.15);
        humor -= 2;

        if (contActividades == 3) {
            duerme = true;
            System.out.println("😴 La mascota se empacó y se fue a dormir.");
        }

        controlarLimites();
        return true;
    }

    public boolean dormir() {
        if (!vive) return false;
        if (duerme) return false; // ya está dormida

        duerme = true;
        energia += 25;
        humor += 2;
        controlarLimites();
        return true;
    }

    public boolean despertar() {
        if (!vive) return false;
        if (!duerme) return false; // ya está despierta

        duerme = false;
        humor -= 1;
        controlarLimites();
        return true;
    }

    @Override
    public String toString() {
        return "Mascota{" +
                "nombre='" + nombre + '\'' +
                ", energia=" + energia +
                ", humor=" + humor +
                ", duerme=" + duerme +
                ", vive=" + vive +
                '}';
    }
}
