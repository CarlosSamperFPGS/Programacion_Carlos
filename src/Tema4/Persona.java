package Tema4;

public class Persona {

    // Atributos
    private String nombre;
    private int edad;
    private static final int edad_def = 5;

    // Constructor vacío
    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = edad_def;
    }

    // Constructor con parámetro de nombre solamente
    public Persona(String nombre) {
        this.nombre = nombre;
        this.edad = edad_def;
    }

    // Contructor completo
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }


    // Métodos
    public static void ShowInfo(){
        System.out.println("Las personas tienen" + edad_def + "años");

    }
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre);
    }

    public void cumpliredad() {
        edad++;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

}
