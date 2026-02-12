package Tema6;

import Tema4.Actividad1.Utils;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] vector = new double[5];

        System.out.println(Utils.ansiBold + "Por favor, introduce 5 números decimales:" + Utils.ansiReset);

        for (int i = 0; i < vector.length; i++) {
            try {
                System.out.print("Introduce el valor para la posición " + (i + 1) + ": ");
                vector[i] = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(Utils.ansiRed + "Error: El valor introducido no es un número válido. Inténtalo de nuevo." + Utils.ansiReset);
                sc.next();
                i--; // Decrementamos i para repetir la iteración de esta posición
            }
        }

        System.out.println(Utils.ansiGreen + "\n¡Vector completado!" + Utils.ansiReset);
        System.out.print("Valores introducidos: ");
        for (double valor : vector) {
            System.out.print(valor + " | ");
        }
        
        sc.close();
    }
}
