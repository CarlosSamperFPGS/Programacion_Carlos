package Tema4.Actividad1;

public class PersonaMain {
    public static void main(String[] args) {
        // Crear una persona con el constructor por defecto
        Persona persona1 = new Persona();
        System.out.println("--- Persona 1 (Defecto) ---");
        persona1.print();
        persona1.isAdult();
        persona1.isRetired();
        System.out.println();

        // Crear una persona con el constructor completo (datos válidos)
        Persona persona2 = new Persona(12345678, "Ana", "García", 30);
        System.out.println("--- Persona 2 (Válida) ---");
        persona2.print();
        persona2.isAdult();
        persona2.isRetired();
        System.out.println();

        // Crear una persona con el constructor completo (datos inválidos)
        Persona persona3 = new Persona(87654321, "123", "Pérez", 150); // Nombre inválido, edad inválida
        System.out.println("--- Persona 3 (Inválida) ---");
        persona3.print(); // Debería mostrar los valores por defecto
        persona3.isAdult();
        persona3.isRetired();
        System.out.println();

        // Probar setters y getters
        persona1.setNombre("Carlos");
        persona1.setApellidos("Ruiz");
        persona1.setEdad(68);
        System.out.println("--- Persona 1 (Modificada) ---");
        persona1.print();
        persona1.isAdult();
        persona1.isRetired();
        System.out.println();

        // Probar diferencia de edad
        System.out.println("--- Diferencia de edad ---");
        persona1.ageDifference(persona2);
        persona2.ageDifference(persona1);
        System.out.println();

        // Probar con un DNI que no sea válido
        Persona persona4 = new Persona(123, "Juan", "Lopez", 25);
        System.out.println("--- Persona 4 (DNI inválido) ---");
        persona4.print();
        System.out.println();
    }
}
