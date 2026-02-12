package Tema6;

import Tema4.Actividad1.Utils;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // 1. Crear vector de tamaño N (1-100)
        int N = rand.nextInt(100) + 1;
        int[] vector = new int[N];

        // 2. Rellenar con valores aleatorios (1-10)
        for (int i = 0; i < vector.length; i++) {
            vector[i] = rand.nextInt(10) + 1;
        }

        System.out.println(Utils.ansiBold + "Se ha generado un vector aleatorio de tamaño " + N + Utils.ansiReset);
        System.out.println("(Los índices válidos son de 0 a " + (N - 1) + ")");

        // 3. Bucle de consulta
        while (true) {
            try {
                System.out.print(Utils.ansiCyan + "\nIntroduce la posición que quieres ver (número negativo para salir): " + Utils.ansiReset);
                int posicion = sc.nextInt();

                if (posicion < 0) {
                    System.out.println(Utils.ansiYellow + "Saliendo del programa..." + Utils.ansiReset);
                    break;
                }

                // Acceso al array (puede lanzar ArrayIndexOutOfBoundsException)
                System.out.println(Utils.ansiGreen + "Valor en la posición " + posicion + ": " + vector[posicion] + Utils.ansiReset);

            } catch (InputMismatchException e) {
                System.out.println(Utils.ansiRed + "Error: Debes introducir un número entero válido." + Utils.ansiReset);
                sc.next(); // Limpiar el buffer del scanner
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(Utils.ansiRed + "Error: La posición " + e.getMessage() + " no existe en el vector." + Utils.ansiReset);
            } catch (Exception e) {
                System.out.println(Utils.ansiRed + "Error inesperado: " + e.toString() + Utils.ansiReset);
            }
        }

        sc.close();
    }
}
