package utn.frc.bda.semana2.apunte6;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ascensor {


    // atributos
    private int cantMaxPersonas;
    private int pisoActual;
    private int cantPersonasAdentro;


    // contruscturtor
    public ascensor (int cantMaxPersonas) {
        this.cantMaxPersonas = cantMaxPersonas;
        this.pisoActual = 0;
        this.cantPersonasAdentro = 0;
    }

    //metodo para desplzarse a un piso
    public boolean irAPiso (int pisoDestino) {
        if (pisoDestino >= -2 && pisoDestino <= 10 ) {
            this.pisoActual = pisoDestino;
            return true;
        } else {
            return false;
        }
    }
    // subir personas
    public int subirPersonas(int cantidad) {
        if (cantidad <= 0) {
            return 0; // no se puede subir una cant invalida
        }
        int espacioDisponible = cantMaxPersonas - cantPersonasAdentro;
        int suben = Math.min(cantidad, espacioDisponible);
        cantPersonasAdentro += suben;
        return suben;
    }
    // bajar persona
    public int bajarPersonas(int cantidad) {
        if (cantidad <= 0) {
            return 0 ;
        }
        int bajan = Math.min(cantidad, cantPersonasAdentro);
        cantPersonasAdentro -= bajan;
        return bajan;
    }
    // to string
    public String toString() {
        return "Ascendor [Piso actual: " + pisoActual + ", cantPersonas: " + cantPersonasAdentro + "]";
    }

}
