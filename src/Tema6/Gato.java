package Tema6;

public class Gato {
    // Atributos
    private String nombre;
    private int edad;

    // CONSTANTES
    private static final String NOMBRE_BASE = "Maroy";
    public static final int EDAD_BASE = 2;

    // Constructor Vacío
    public Gato() {
        this.nombre = NOMBRE_BASE;
        this.edad = EDAD_BASE;
    }

    // Constructor
    public Gato(String nombre, int edad) throws Exception {
        // Usamos los setters para aprovechar la validación
        this.setNombre(nombre);
        this.setEdad(edad);
    }

    // Método imprimir
    public void imprimir() {
        System.out.println("Gato: " + nombre + " | Edad: " + edad + " años.");
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Setters con validación y lanzamiento de excepciones
    public void setNombre(String nombre) throws Exception {
        if (nombre == null || nombre.length() < 3) {
            throw new Exception("El nombre debe tener al menos 3 caracteres.");
        }
        this.nombre = nombre;
    }

    public void setEdad(int edad) throws Exception {
        if (edad < 0) {
            throw new Exception("La edad no puede ser negativa.");
        }
        this.edad = edad;
    }
}