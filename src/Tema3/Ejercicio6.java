package Tema3;

//-------------------------------------------------------------------------------
// Escribe un programa que muestre las tablas de multiplicar del 1 al 10.
//-------------------------------------------------------------------------------

// Utilizaremos la función creada en el ejercicio 5

public class Ejercicio6 {

    // No creamos ninguna función en este ejercicio

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Tabla de multiplicar del " + i);
            Ejercicio5.showMultiplicationTable(i);
            System.out.println(); // Para una línea en blanco entre tablas
        }
    }
}
// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭