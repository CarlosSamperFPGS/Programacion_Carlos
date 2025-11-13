package Tema3;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

public class Ejercicio3 {
    // Función que determina si el Radio introducido es válido
    public static boolean validRadius(double radius) {
        return radius > 0;
    }

    // Funciones para calcular el perímetro y la superficie del círculo
    public static double calculateCirclePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }

    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        double radius;

        do {
            System.out.println("Introduce un radio válido (mayor que 0):");
            radius = sc.nextDouble();
        } while (!validRadius(radius));
        // Entramos en un bucle hasta que la primera función nos diga que el radio es válido

        double perimeter = calculateCirclePerimeter(radius);
        double area = calculateCircleArea(radius);

        System.out.println("El perímetro del círculo es: " + perimeter);
        System.out.println("La superficie del círculo es: " + area);

        sc.close();
    }
}
