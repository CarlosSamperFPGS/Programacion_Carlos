package Tema6;

import Tema4.Actividad1.Utils;

public class Ejercicio6 {

    public static void main(String[] args) {
        System.out.println(Utils.ansiBold + "--- PRUEBAS CLASE GATO ---" + Utils.ansiReset);

        // Prueba 1: Gato válido
        System.out.println(Utils.ansiCyan + "\n1. Intentando crear un gato válido (Garfield, 5)..." + Utils.ansiReset);
        try {
            Gato g1 = new Gato("Garfield", 5);
            g1.imprimir();
            System.out.println(Utils.ansiGreen + "✅ Gato creado correctamente." + Utils.ansiReset);
        } catch (Exception e) {
            System.out.println(Utils.ansiRed + "❌ Error: " + e.getMessage() + Utils.ansiReset);
        }

        // Prueba 2: Nombre corto
        System.out.println(Utils.ansiCyan + "\n2. Intentando crear un gato con nombre corto (Bo, 3)..." + Utils.ansiReset);
        try {
            Gato g2 = new Gato("Bo", 3);
            g2.imprimir();
        } catch (Exception e) {
            System.out.println(Utils.ansiRed + "❌ Error esperado: " + e.getMessage() + Utils.ansiReset);
        }

        // Prueba 3: Edad negativa
        System.out.println(Utils.ansiCyan + "\n3. Intentando crear un gato con edad negativa (Felix, -2)..." + Utils.ansiReset);
        try {
            Gato g3 = new Gato("Felix", -2);
            g3.imprimir();
        } catch (Exception e) {
            System.out.println(Utils.ansiRed + "❌ Error esperado: " + e.getMessage() + Utils.ansiReset);
        }

        // Prueba 4: Modificación con setters
        System.out.println(Utils.ansiCyan + "\n4. Probando setters en un gato existente..." + Utils.ansiReset);
        try {
            Gato g4 = new Gato("Misifú", 2);
            g4.imprimir();

            System.out.println("-> Cambiando nombre a 'Tom'...");
            g4.setNombre("Tom");
            g4.imprimir();

            System.out.println("-> Intentando poner edad -5...");
            g4.setEdad(-5);
        } catch (Exception e) {
            System.out.println(Utils.ansiRed + "❌ Error al modificar: " + e.getMessage() + Utils.ansiReset);
        }
    }
}
