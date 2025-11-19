package Tema3;

public class MyMath {

    // Función para calcular el perímetro de un círculo
    public static double circlePerimeter(double radio) {
        return 2 * Math.PI * radio;
    }

    // Función para calcular el área de un círculo
    public static double circleArea(double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    // Función para calcular el perímetro de un cuadrado
    public static double squarePerimeter(double lado) {
        return 4 * lado;
    }

    // Función para calcular el área de un cuadrado
    public static double squareArea(double lado) {
        return Math.pow(lado, 2);
    }

    // Función para calcular el perímetro de un rectángulo
    public static double rectanglePerimeter(double altura, double base) {
        return 2 * (altura + base);
    }

    // Función para calcular el área de un rectángulo
    public static double rectangleArea(double largo, double ancho) {
        return largo * ancho;
    }

    // Función que comprueba si un número es Primo
    public static boolean esPrimo(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    // Función que comprueba si un número no es Primo
    public static boolean noEsPrimo(int numero) {
        return !esPrimo(numero);
    }

    // Función que indica el número de dígitos de un número entero
    public static int numeroDeDigitos(int numero) {
        if (numero == 0) {
            return 1;
        }
        int digitos = 0;
        int num = Math.abs(numero);
        while (num > 0) {
            num /= 10;
            digitos++;
        }
        return digitos;
    }

    // Función que indica el número de dígitos pares de un número entero
    public static int numeroDeDigitosPares(int numero) {
        int digitosPares = 0;
        int num = Math.abs(numero);
        while (num > 0) {
            int digito = num % 10;
            if (digito % 2 == 0) {
                digitosPares++;
            }
            num /= 10;
        }
        return digitosPares;
    }

    // Función que indica el número de dígitos impares de un número entero
    public static int numeroDeDigitosImpares(int numero) {
        int digitosImpares = 0;
        int num = Math.abs(numero);
        while (num > 0) {
            int digito = num % 10;
            if (digito % 2 != 0) {
                digitosImpares++;
            }
            num /= 10;
        }
        return digitosImpares;
    }

    // Función que calcula el factorial de un número.
    public static long factorial(int numero) {
        if (numero < 0) {
            return -1; // Indicador de error para números negativos
        }
        long resultado = 1;
        for (int i = 1; i <= numero; i++) {
            resultado *= i;
        }
        return resultado;
    }

    // Función que calcula el factorial de un número recursivamente.
    public static long factorialRecursivo(int numero) {
        if (numero < 0) {
            return -1; // Indicador de error para números negativos
        }
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorialRecursivo(numero - 1);
        }
    }

    // Función que indica el número de soluciones de una ecuación de segundo grado.
    public static int numeroSolucionesEcuacionSegundoGrado(double a, double b, double c) {
        double discriminante = b * b - 4 * a * c;
        if (discriminante > 0) {
            return 2;
        } else if (discriminante == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // Función que suma los dígitos de un número.
    public static int sumaDigitos(int numero) {
        int suma = 0;
        int num = Math.abs(numero);
        while (num > 0) {
            suma += num % 10;
            num /= 10;
        }
        return suma;
    }
}