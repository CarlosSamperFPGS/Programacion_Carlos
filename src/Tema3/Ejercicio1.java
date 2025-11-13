package Tema3;

//𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

import java.util.Scanner;

public class Ejercicio1 {

    // Función para saber si un número es positivo o negativo
    public static int  numberSing (int num) {
        int isPositive = Integer.compare(num, 0);
        return isPositive == 0 ? num : isPositive;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int isPositive = numberSing(num);
        if (isPositive == 0) {
            System.out.println("El número es igual a 0");
        } else if (isPositive == 1) {
            System.out.println("El número es positivo");
        } else {
            System.out.println("El número es negativo");
        }
    }
}

