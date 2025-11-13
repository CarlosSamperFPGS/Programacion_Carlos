package Tema3;

//-------------------------------------------------------------------------------
// Escribe un programa que lea por consola un día (1-31), un mes (1-12) y
// un año y nos indique si la fecha es correcta o no.
//-------------------------------------------------------------------------------

import java.util.Scanner;

public class Ejercicio8 {
    // Función para verificar si un año es bisiesto
    public static boolean esBisiesto(int anio) {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    // Función para verificar si la fecha es correcta
    public static boolean fechaCorrecta(int dia, int mes, int anio) {
        if (anio < 1 || mes < 1 || mes > 12 || dia < 1) {
            return false;
        }

        int[] diasPorMes = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (esBisiesto(anio)) {
            diasPorMes[2] = 29;
        }

        return dia <= diasPorMes[mes];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el día:");
        int dia = sc.nextInt();

        System.out.println("Introduce el mes:");
        int mes = sc.nextInt();

        System.out.println("Introduce el año:");
        int anio = sc.nextInt();

        if (fechaCorrecta(dia, mes, anio)) {
            System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es correcta.");
        } else {
            System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " no es correcta.");
        }

        sc.close();
    }
}
// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭