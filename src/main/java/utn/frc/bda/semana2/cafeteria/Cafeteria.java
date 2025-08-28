package utn.frc.bda.semana2.cafeteria;

import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



    public class Cafeteria {

        // atributos
        private String marca;
        private String modelo;
        private int capacidadMaxima;
        private int contenidoActual;
        private boolean encendida;
        private int cafeServidos;
        private int temperatura;




        // metodos

        public void encender() {
            this.encendida = true;
            this.temperatura = 20;
            this.contenidoActual = 0;
        }

        public void apagar() {
            this.encendida = false;
            this.cafeServidos = 0;
        }

        public boolean cargarAgua(int ml) {
            if (encendida) {
                this.contenidoActual += ml;
                if (this.contenidoActual > this.capacidadMaxima) {
                    this.contenidoActual = this.capacidadMaxima;
                }
                return true;
            }
            return false;
        }


        public boolean calentar() {
            if (encendida) {
                this.temperatura += 40;
                if (temperatura >= 100) {
                    this.temperatura = 100;
                }
                return true;
            }
            return false;
        }

        public boolean servirCafe() {
            if (encendida && contenidoActual >= 100 && temperatura >= 90) {
                contenidoActual -= 100;
                cafeServidos += 1;
                return true;
            } else {
                return false;
            }
        }

        @Override
        public String toString() {
            return "Cafetera " + marca + " " + modelo + " - Agua: " + contenidoActual + "ml, Temperatura: " + temperatura + "°C, Servidos: " + cafeServidos + ", Estado: " + (encendida ? "encendida" : "apagada");
        }






    }


