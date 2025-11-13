package Tema3;

//-------------------------------------------------------------------------------
// Escribe un programa que lea por consola un día (1-31), un mes (1-12) y
// un año y nos indique si la fecha es correcta o no.
//-------------------------------------------------------------------------------

import java.util.Scanner;

public class Ejercicio8 {
    // Función para verificar si un año es bisiesto
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Función para verificar si la fecha es correcta
    public static boolean isDateCorrect(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (isLeapYear(year)) {
            daysPerMonth[2] = 29;
        }

        return day <= daysPerMonth[month];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce el día:");
        int inputDay = scanner.nextInt();

        System.out.println("Introduce el mes:");
        int inputMonth = scanner.nextInt();

        System.out.println("Introduce el año:");
        int inputYear = scanner.nextInt();

        if (isDateCorrect(inputDay, inputMonth, inputYear)) {
            System.out.println("La fecha " + inputDay + "/" + inputMonth + "/" + inputYear + " es correcta.");
        } else {
            System.out.println("La fecha " + inputDay + "/" + inputMonth + "/" + inputYear + " no es correcta.");
        }

        scanner.close();
    }
}
// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭