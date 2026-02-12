package Tema6;

import Tema4.Actividad1.Utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;

        System.out.println(Utils.ansiBold + "--- PRUEBA DE EXCEPCIONES ---" + Utils.ansiReset);
        System.out.println("Introduce números para probar las funciones.");
        System.out.println("El programa intentará pasar el número a ambas funciones.");
        System.out.println("Introduce '0' para salir.");

        while (continuar) {
            try {
                System.out.print(Utils.ansiCyan + "\nIntroduce un número entero: " + Utils.ansiReset);
                int numero = sc.nextInt();

                if (numero == 0) {
                    continuar = false;
                    System.out.println(Utils.ansiYellow + "Saliendo..." + Utils.ansiReset);
                    continue;
                }

                // Prueba 1: Imprime Positivo
                try {
                    imprimePositivo(numero);
                } catch (Exception e) {
                    System.out.println(Utils.ansiRed + "❌ Error en imprimePositivo: " + e.getMessage() + Utils.ansiReset);
                }

                // Prueba 2: Imprime Negativo
                try {
                    imprimeNegativo(numero);
                } catch (Exception e) {
                    System.out.println(Utils.ansiRed + "❌ Error en imprimeNegativo: " + e.getMessage() + Utils.ansiReset);
                }

            } catch (InputMismatchException e) {
                System.out.println(Utils.ansiRed + "Error: Debes introducir un número entero." + Utils.ansiReset);
                sc.next(); // Limpiar buffer
            }
        }
        sc.close();
    }

    /**
     * Imprime el valor p. Lanza una Exception si p < 0.
     */
    public static void imprimePositivo(int p) throws Exception {
        if (p < 0) {
            throw new Exception("El valor " + p + " es negativo.");
        }
        System.out.println(Utils.ansiGreen + "✅ imprimePositivo: " + p + Utils.ansiReset);
    }

    /**
     * Imprime el valor n. Lanza una Exception si n >= 0.
     */
    public static void imprimeNegativo(int n) throws Exception {
        if (n >= 0) {
            throw new Exception("El valor " + n + " es positivo o cero.");
        }
        System.out.println(Utils.ansiGreen + "✅ imprimeNegativo: " + n + Utils.ansiReset);
    }
}
