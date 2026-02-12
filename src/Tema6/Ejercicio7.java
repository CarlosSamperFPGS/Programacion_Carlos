package Tema6;

import Tema4.Actividad1.Utils;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Gato> listaGatos = new ArrayList<>();
        final int CANTIDAD_GATOS = 5;

        System.out.println(Utils.ansiBold + "--- REGISTRO DE GATOS ---" + Utils.ansiReset);
        System.out.println("Por favor, introduce los datos de " + CANTIDAD_GATOS + " gatos válidos.");

        while (listaGatos.size() < CANTIDAD_GATOS) {
            try {
                System.out.println(Utils.ansiCyan + "\nIntroduciendo Gato nº " + (listaGatos.size() + 1) + ":" + Utils.ansiReset);

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Edad: ");
                int edad = sc.nextInt();
                sc.nextLine();

                // Si los datos no son válidos, el constructor lanzará una Exception
                // y saltaremos al bloque catch ANTES de añadirlo a la lista.
                Gato nuevoGato = new Gato(nombre, edad);

                // El gato es válido
                listaGatos.add(nuevoGato);
                System.out.println(Utils.ansiGreen + "✅ Gato añadido correctamente." + Utils.ansiReset);

            } catch (InputMismatchException e) {
                System.out.println(Utils.ansiRed + "❌ Error: La edad debe ser un número entero." + Utils.ansiReset);
                sc.nextLine();
            } catch (Exception e) {
                // Captura las excepciones de validación de la clase Gato
                System.out.println(Utils.ansiRed + "❌ Error: " + e.getMessage() + Utils.ansiReset);
            }
        }

        System.out.println(Utils.ansiBold + "\n--- LISTADO FINAL DE GATOS ---" + Utils.ansiReset);
        for (Gato g : listaGatos) {
            g.imprimir();
        }

        sc.close();
    }
}
