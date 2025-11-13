package Tema3;

//--------------------------------------------------------
// Escribe un programa que pida números enteros positivos hasta que se
// introduzca el 0, para cada número nos dirá si es primo o no.
//--------------------------------------------------------

import java.util.Scanner;

public class Ejercicio7 {
    // Función para saber si un número es primo
    public static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        do {
            System.out.println("Introduce un número entero positivo (0 para salir):");
            num = sc.nextInt();

            if (num > 0) {
                if (esPrimo(num)) {
                    System.out.println(num + " es un número primo.");
                } else {
                    System.out.println(num + " no es un número primo.");
                }
            } else if (num < 0) {
                System.out.println("Por favor, introduce un número positivo.");
            }
        } while (num != 0);

        System.out.println("Programa finalizado.");
        sc.close();
    }
}
// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭