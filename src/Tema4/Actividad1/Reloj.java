package Tema4.Actividad1;

public class Reloj {

    // Atributos
    private int horas;
    private int minutos;
    private int segundos;
    private boolean isAmFormat;
    public static final int horasDefault = 1;
    public static final int minutosDefault = 0;
    public static final int segundosDefault = 0;
    public static final boolean isAmFormatDefault = false;
    public static final int horaAm = 12;


    // Constructor vacio
    public Reloj(){
        this.horas = horasDefault;
        this.minutos = minutosDefault;
        this.segundos = segundosDefault;
        this.isAmFormat = isAmFormatDefault;

    }

    // Contructor completo
    public Reloj(int horas, int minutos, int segundos, boolean isAmFormat){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.isAmFormat = isAmFormat;

    }

    // Métodos
    public void mostrarHora(){
        if (isAmFormat && horas > horaAm) {
            horas -= horaAm;
        }
            System.out.println("La hora es " + horas + ":" + minutos + ":" + segundos);

    }

    public String toString() {
        if (isAmFormat && horas > horaAm) {
            horas -= horaAm;
        }
        return horas + ":" + minutos + ":" + segundos;
    }


    // Métodos Getter y Setter
    public int getHoras() {
        return horas;
    }
    public void setHoras(int horas) {
        this.horas = horas;
        //COMPROBAR HORA >0 Y <24
    }

    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    public void setSegundos(int segundos) {
        this.segundos = segundos;
    }
}
