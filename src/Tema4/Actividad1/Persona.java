package Tema4.Actividad1;

public class Persona {
    // Atributos
    private final String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private static final String dni_def = "12345678X";
    private static final String nombre_def = "Pedro";
    private static final String apellidos_def = "Martinez";
    private static final int edad_def = 20;
    private static final int edadAdult = 18;
    private static final int edadRetiro = 65;

    // Contructor
    public Persona() {
        this.dni = dni_def;
        this.nombre = nombre_def;
        this.apellidos = apellidos_def;
        this.edad = edad_def;
    }

    // Constructor completo
    public Persona(int dni, String nombre, String apellidos, int edad) {
        if (Utils.validateName(nombre) && Utils.validateName(apellidos) && Utils.validateAge(edad)) {
            this.dni = Utils.letraDni(dni);
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.edad = edad;
        } else {
            this.dni = dni_def;
            System.out.println("Datos Inválidos");
        }
    }

    // Métodos
    public void print() {
        System.out.println("Mi DNI es: " + dni);
        System.out.println("Mi Nombre es: " + nombre);
        System.out.println("Mis Apellidos son: " + apellidos);
        System.out.println("Mi Edad es: " + edad);
    }

    //toString

    public void isAdult() {
        if (edad >= edadAdult) {
            System.out.println("Soy mayor de edad");
            //boolean= true
        } else  {
            System.out.println("Soy menor de edad");
        }
    }

    public void isRetired() {
        if (edad >= edadRetiro) {
            System.out.println("Estoy Retirado");
        } else  {
            System.out.println("No estoy Retirado");
        }
    }

    public void ageDifference(Persona p) {
        int diferencia = Math.abs(this.edad - p.edad);
        System.out.println("La diferencia de edad es: " + diferencia);
    }


    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

}
