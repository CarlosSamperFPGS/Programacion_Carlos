package Tema3;

//-------------------------------------------------------------------------------
//10)Escribe un programa que muestre un menú con 9 opciones (si tus
// ejercicios son modulares no debería costarte demasiado):
//-------------------------------------------------------------------------------

import java.util.Scanner;

import static Tema3.Ejercicio1.checkNumberSign;

public class Ejercicio10 {
    // Procedimiento del menú para este ejercicio
    public static void showMainMenu() {
        System.out.println("Bienvenido al menú de ejercicios de Hazard");
        System.out.println("1. Muestra el signo de un número introducido por el usuario");
        System.out.println("2. Indica si el usuario es mayor de edad o no");
        System.out.println("3. Calcula el área y perímetro de un círculo");
        System.out.println("4. Conversor de euros a dólares y de dólares a euros");
        System.out.println("5. Mostrar la tabla de multiplicar de un número del 1 al 10");
        System.out.println("6. Mostrar tablas de multiplicar del 1 al 10");
        System.out.println("7. Comprobador de números primos");
        System.out.println("8. Comprobador de fechas");
        System.out.println("9. Dibujar triángulos");
        System.out.println("0. Salir");
        System.out.println("Elige una opción");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuOption;

        do {
            showMainMenu();
            menuOption = scanner.nextInt();

            switch (menuOption) {
                case 1: // Indica si el número introducido es positivo o negativo
                    System.out.println("Has elegido la opción 1");
                    System.out.println("Introduce un número");
                    int numberToCheck = scanner.nextInt();
                    int sign = checkNumberSign(numberToCheck);
                    if (sign == 0) {
                        System.out.println("El número es igual a 0");
                    } else if (sign > 0) {
                        System.out.println("El número es positivo");
                    } else {
                        System.out.println("El número es negativo");
                    }
                    break;
                case 2: // Indica si la edad introducida es mayor de edad o no
                    System.out.println("Has elegido la opción 2");
                    System.out.println("Introduce la edad del sujeto");
                    int userAge = scanner.nextInt();
                    if (userAge < 0) {
                        System.out.println("Edad no válida");
                    } else {
                        if (Ejercicio2.isAdult(userAge)) {
                            System.out.println("El sujeto es mayor de edad");
                        } else {
                            System.out.println("El sujeto es menor de edad");
                        }
                    }
                    break;
                case 3: // Calcula el área y perímetro de un círculo con el radio introducido por el usuario
                    System.out.println("Has elegido la opción 3");
                    System.out.println("Introduce un radio válido (mayor que 0):");
                    double circleRadius = scanner.nextDouble();
                    if (Ejercicio3.isRadiusValid(circleRadius)) {
                        double perimeter = Ejercicio3.calculateCirclePerimeter(circleRadius);
                        double area = Ejercicio3.calculateCircleArea(circleRadius);
                        System.out.println("El area del círculo es " + area + " y el perímetro es " + perimeter);
                    } else {
                        System.out.println("Radio no válido.");
                    }
                    break;
                case 4: // Conversor de Euros a Dólares y de Dólares a Euros
                    System.out.println("Has elegido la opción 4");
                    Ejercicio4.showMenu();
                    int currencyOption = scanner.nextInt();
                    double amountToConvert;
                    switch (currencyOption) {
                        case 1: // Conversor de Euros a Dólares
                            System.out.println("Introduce la cantidad de euros a convertir");
                            amountToConvert = scanner.nextDouble();
                            System.out.println(amountToConvert + " euros son " + Ejercicio4.convertEurosToDollars(amountToConvert) + " dólares");
                            break;
                        case 2: // Conversor de Dólares a Euros
                            System.out.println("Introduce la cantidad de dólares a convertir");
                            amountToConvert = scanner.nextDouble();
                            System.out.println(amountToConvert + " dólares son " + Ejercicio4.convertDollarsToEuros(amountToConvert) + " euros");
                            break;
                        case 3: // Salir
                            System.out.println("Gracias por usar el conversor de divisas de Hazard");
                            break;
                        default:
                            System.out.println("Opción no válida.");
                    }
                    break;
                case 5: // Tabla de multiplicar de 1 número del 1 al 10
                    System.out.println("Has elegido la opción 5");
                    System.out.println("Introduce el número del que deseas saber la tabla de multiplicar");
                    int tableNumber = scanner.nextInt();
                    Ejercicio5.showMultiplicationTable(tableNumber);
                    break;
                case 6: // Tabla de multiplicar del 1 al 10
                    System.out.println("Has elegido la opción 6");
                    for (int i = 1; i <= 10; i++) {
                        System.out.println("Tabla de multiplicar del " + i);
                        Ejercicio5.showMultiplicationTable(i);
                        System.out.println();
                    }
                    break;
                case 7: // Comprobador de números primos
                    System.out.println("Has elegido la opción 7");
                    System.out.println("Introduce un número entero positivo:");
                    int primeCheckNumber = scanner.nextInt();
                    if (primeCheckNumber > 0) {
                        if (Ejercicio7.isPrime(primeCheckNumber)) {
                            System.out.println(primeCheckNumber + " es un número primo.");
                        } else {
                            System.out.println(primeCheckNumber + " no es un número primo.");
                        }
                    } else {
                        System.out.println("Por favor, introduce un número positivo.");
                    }
                    break;
                case 8: // Comprobador de fechas
                    System.out.println("Has elegido la opción 8");
                    System.out.println("Bienvenido al comprobador de fechas");
                    System.out.println("Introduce el día:");
                    int day = scanner.nextInt();
                    System.out.println("Introduce el mes:");
                    int month = scanner.nextInt();
                    System.out.println("Introduce el año:");
                    int year = scanner.nextInt();

                    if (Ejercicio8.isDateCorrect(day, month, year)) {
                        System.out.println("La fecha " + day + "/" + month + "/" + year + " es correcta.");
                    } else {
                        System.out.println("La fecha " + day + "/" + month + "/" + year + " no es correcta.");
                    }
                    break;
                case 9: // Dibujar triángulos
                    System.out.println("Has elegido la opción 9");
                    System.out.println("Bienvenido al constructor de triangulos");
                    System.out.println("Introduce un carácter");
                    char triangleChar = scanner.next().charAt(0);
                    System.out.println("Introduce el número de líneas del triángulo");
                    int triangleLines = scanner.nextInt();
                    Ejercicio9.drawTriangle(triangleChar, triangleLines);
                    break;
                case 0: // Salir
                    System.out.println("Gracias por usar el menú de ejercicios de Hazard");
                    System.out.println("\uD835\uDCD7\uD835\uDCEE\uD835\uDCEC\uD835\uDCF1\uD835\uDCF8 \uD835\uDCF9\uD835\uDCF8\uD835\uDCFB \uD835\uDCD7\uD835\uDCEA\uD835\uDD03\uD835\uDCEA\uD835\uDCFB\uD835\uDCED");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
            System.out.println("\n--------------------------------------\n");
        } while (menuOption != 0);

        scanner.close();
    }
}