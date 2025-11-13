package Tema3;

//--------------------------------------------------------
// Escribe un programa que pida números enteros positivos hasta que se
// introduzca el 0, para cada número nos dirá si es primo o no.
//--------------------------------------------------------

import java.util.Scanner;

public class Ejercicio7 {
    // Función para saber si un número es primo
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int inputNumber;

        do {
            System.out.println("Introduce un número entero positivo (0 para salir):");
            inputNumber = scanner.nextInt();

            if (inputNumber > 0) {
                if (isPrime(inputNumber)) {
                    System.out.println(inputNumber + " es un número primo.");
                } else {
                    System.out.println(inputNumber + " no es un número primo.");
                }
            } else if (inputNumber < 0) {
                System.out.println("Por favor, introduce un número positivo.");
            }
        } while (inputNumber != 0);

        System.out.println("Programa finalizado.");
        scanner.close();
    }
}
// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭