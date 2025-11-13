package Tema3;

//𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

import java.util.Scanner;

public class Ejercicio1 {

    // Función para saber si un número es positivo, negativo o cero
    public static int checkNumberSign(int number) {
        return Integer.compare(number, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número: ");
        int inputNumber = scanner.nextInt();
        int sign = checkNumberSign(inputNumber);
        
        if (sign == 0) {
            System.out.println("El número es igual a 0");
        } else if (sign > 0) {
            System.out.println("El número es positivo");
        } else {
            System.out.println("El número es negativo");
        }
    }
}
