package Java_Objetos;

import com.sun.tools.javac.Main;

public class Movil {

    // ATRIBUTOS
    private String marca;
    private int bateria;
    private boolean encendido;

    // CONSTRUCTOR
    public Movil(String marca, int bateria) {
        this.marca = marca;
        this.bateria = bateria;
        this.encendido = false;
    }

    // MÉTODOS 1 - todo Encender y Apagar pulsando el botón power
    public void pulsarBotonPower() {

        if (encendido) {
            encendido = false;
            System.out.println("El móvil se ha apagado");
        } else {
            encendido = true;
            System.out.println("El móvil se ha encendido");
        }
    }

    // MÉTODOS 2 - todo Jugar un juego (Móvil encendido y con batería)
    public void jugarJuego() {
        if (encendido && bateria > 20) {
            bateria -= 20;
            System.out.println("Jugando a Clash Royale");

        } else {
            System.out.println("El móvil no está encendido o no tiene batería suficiente");
        }
    }

    // MÉTODOS 3 - todo Cargar el móvil al 100%
    public void cargarMovil() {
        bateria = 100;
    }
}
