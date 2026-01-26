package Tema4;

public class PersonaMain {
    public static void main(String[] args) {
        // Crear un objeto Persona usando el constructor vacío
        Persona persona1 = new Persona();
        persona1.setNombre("Ana");
        persona1.setEdad(27);
        persona1.saludar(); // Salida esperada: Hola, mi nombre es Ana
        System.out.println("Edad inicial de Ana: " + persona1.getEdad());

        persona1.cumpliredad();
        System.out.println("Edad de Ana después de cumplir años: " + persona1.getEdad());

        // Crear un objeto Persona usando el constructor con nombre
        Persona persona2 = new Persona("Poli");
        persona2.saludar(); // Salida esperada: Hola, mi nombre es Poli
        persona2.setEdad(24);
        System.out.println("Edad de Poli: " + persona2.getEdad());

        // Crear un objeto Persona usando el constructor completo
        Persona persona3 = new Persona("Marga", 40);
        persona3.saludar(); // Salida esperada: Hola, mi nombre es Marga
        System.out.println("Edad de Marga: " + persona3.getEdad());

        // Modificar el nombre de persona1 (Ana)
        persona1.setNombre("Ana Viciano");
        persona1.saludar(); // Salida: Hola, mi nombre es Ana Viciano
    }

}
