package Tema5;

public class UsuarioBanco {
    private String nombre;
    private int edad;
    private String dni;

    public UsuarioBanco(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nombre + " (" + dni + ")";
    }
}
