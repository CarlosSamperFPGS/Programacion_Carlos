package Tema3;

//-------------------------------------------------------------------------------
//Escribe un programa que pida un número entero por consola de 1 a 10 y
// te muestre su tabla de multiplicar.
//-------------------------------------------------------------------------------

import java.util.Scanner;

public class Ejercicio5 {
    // Procedimiento para mostrar la tabla de multiplicar de un número del 1 al 10
    public static void showMultiplicationTable(int number) {
        if (number >= 1 && number <= 10) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        } else {
            System.out.println("El número debe estar entre 1 y 10.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número del que deseas saber la tabla de multiplicar");
        int selectedNumber = scanner.nextInt();
        showMultiplicationTable(selectedNumber);
        scanner.close();
    }
}
// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭