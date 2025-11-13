package Tema3;

//-------------------------------------------------------------------------------
//Escribe un programa que pida un número entero por consola de 1 a 10 y
// te muestre su tabla de multiplicar.
//-------------------------------------------------------------------------------

import java.util.Scanner;

public class Ejercicio5 {
    // Procedimiento para mostrar la tabla de multiplicar de un número del 1 al 10
    public static void TablaDeMultiplicar(int num) {
        if (num < 1 || num > 10) {
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + num * i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el número del que deseas saber la tabla de multiplicar");
        int num = sc.nextInt();
        TablaDeMultiplicar(num);
        }
    }
// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭