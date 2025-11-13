package Tema3;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

import java.util.Scanner;

public class Ejercicio3 {
    // Función que determina si el Radio introducido es válido
    public static boolean isRadiusValid(double radius) {
        return radius > 0;
    }

    // Funciones para calcular el perímetro y la superficie del círculo
    public static double calculateCirclePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double circleRadius;

        do {
            System.out.println("Introduce un radio válido (mayor que 0):");
            circleRadius = scanner.nextDouble();
        } while (!isRadiusValid(circleRadius));
        // Entramos en un bucle hasta que la primera función nos diga que el radio es válido

        double circlePerimeter = calculateCirclePerimeter(circleRadius);
        double circleArea = calculateCircleArea(circleRadius);

        System.out.println("El perímetro del círculo es: " + circlePerimeter);
        System.out.println("La superficie del círculo es: " + circleArea);

        scanner.close();
    }
}
