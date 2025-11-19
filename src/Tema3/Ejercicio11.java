package Tema3;

import java.util.Scanner;

public class Ejercicio11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Probar funciones de círculo
        System.out.print("Introduce el radio de un círculo: ");
        double radio = scanner.nextDouble();
        System.out.println("Perímetro del círculo: " + MyMath.circlePerimeter(radio));
        System.out.println("Área del círculo: " + MyMath.circleArea(radio));
        System.out.println("---------------------------------");

        // Probar funciones de cuadrado
        System.out.print("Introduce el lado de un cuadrado: ");
        double lado = scanner.nextDouble();
        System.out.println("Perímetro del cuadrado: " + MyMath.squarePerimeter(lado));
        System.out.println("Área del cuadrado: " + MyMath.squareArea(lado));
        System.out.println("---------------------------------");

        // Probar funciones de rectángulo
        System.out.print("Introduce la altura de un rectángulo: ");
        double altura = scanner.nextDouble();
        System.out.print("Introduce la base de un rectángulo: ");
        double base = scanner.nextDouble();
        System.out.println("Perímetro del rectángulo: " + MyMath.rectanglePerimeter(altura, base));
        System.out.println("Área del rectángulo: " + MyMath.rectangleArea(altura, base));
        System.out.println("---------------------------------");

        // Probar funciones de números primos
        System.out.print("Introduce un número para comprobar si es primo: ");
        int numeroPrimo = scanner.nextInt();
        System.out.println("¿Es primo? " + MyMath.esPrimo(numeroPrimo));
        System.out.println("¿No es primo? " + MyMath.noEsPrimo(numeroPrimo));
        System.out.println("---------------------------------");

        // Probar función de número de dígitos
        System.out.print("Introduce un número para contar sus dígitos: ");
        int numeroDigitos = scanner.nextInt();
        System.out.println("Número de dígitos: " + MyMath.numeroDeDigitos(numeroDigitos));
        System.out.println("Número de dígitos pares:" + MyMath.numeroDeDigitosPares(numeroDigitos));
        System.out.println("Número de dígitos impares:" + MyMath.numeroDeDigitosImpares(numeroDigitos));
        System.out.println("---------------------------------");

        // Probar funciones de factorial
        System.out.print("Introduce un número para calcular su factorial: ");
        int numeroFactorial = scanner.nextInt();
        System.out.println("Factorial (iterativo): " + MyMath.factorial(numeroFactorial));
        System.out.println("Factorial (recursivo): " + MyMath.factorialRecursivo(numeroFactorial));
        System.out.println("---------------------------------");

        // Probar función de ecuación de segundo grado
        System.out.println("Introduce los coeficientes de una ecuación de segundo grado (a, b, c):");
        System.out.print("a: ");
        double a = scanner.nextDouble();
        System.out.print("b: ");
        double b = scanner.nextDouble();
        System.out.print("c: ");
        double c = scanner.nextDouble();
        System.out.println("Número de soluciones: " + MyMath.numeroSolucionesEcuacionSegundoGrado(a, b, c));
        System.out.println("---------------------------------");

        // Probar función de suma de dígitos
        System.out.print("Introduce un número para sumar sus dígitos: ");
        int numeroSuma = scanner.nextInt();
        System.out.println("Suma de dígitos: " + MyMath.sumaDigitos(numeroSuma));
        System.out.println("---------------------------------");

        scanner.close();
    }
}
