package Tema3;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

import java.util.Scanner;

public class Ejercicio2 {
    // Función para saber si un número supera un umbral, en este caso 18
    public static boolean isAdult(int age) {
        boolean adulto;
        adulto = age >= 18;
        return adulto;
    }
    public static void main(String[] args) {
        // Utilizamos ambas funciones, una asegura que el número sea positivo, la otra para saber si es mayor de edad

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la edad del sujeto");
        int age = sc.nextInt();
        int pos = Ejercicio1.numberSing(age);
        if (pos < 0) {
            System.out.println("Edad no válida");
        }
        boolean adult = isAdult(age);
        if (adult) {
            System.out.println("El sujeto es mayor de edad");
        } else  {
            System.out.println("El sujeto es menor de edad");
        }
    }
}

