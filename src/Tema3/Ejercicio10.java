package Tema3;

//-------------------------------------------------------------------------------
//10)Escribe un programa que muestre un menú con 9 opciones (si tus
// ejercicios son modulares no debería costarte demasiado):
//-------------------------------------------------------------------------------

import java.util.Scanner;

import static Tema3.Ejercicio8.fechaCorrecta;
import static Tema3.Ejercicio9.dibujarTriangulo;

public class Ejercicio10 {
    // Procedimiento del menú para este ejercicio
    public static void showMenu10() {
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
        showMenu10();
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1: // Indica si el número introducido es positivo o negativo
                System.out.println("Has elegido la opción 1");
                System.out.println("Introduce un número");
                int num = sc.nextInt();
                int isPositive = Ejercicio1.numberSing(num);
                if (isPositive == 0) {
                    System.out.println("El número es igual a 0");
                    } else if (isPositive == 1) {
                    System.out.println("El número es positivo");
                    } else {
                    System.out.println("El número es negativo");
                }
                break;
            case 2: // Indica si la edad introducida es mayor de edad o no
                    System.out.println("Has elegido la opción 2");
                    System.out.println("Introduce la edad del sujeto");
                    int age = sc.nextInt();
                    int pos = Ejercicio1.numberSing(age);
                    if (pos < 0) {
                        System.out.println("Edad no válida");
                    }
                    boolean adult = Ejercicio2.isAdult(age);
                    if (adult) {
                        System.out.println("El sujeto es mayor de edad");
                    } else  {
                        System.out.println("El sujeto es menor de edad");
                    }
                    break;
            case 3: // Calcula el área y perímetro de un círculo con el radio introducido por el usuario
                System.out.println("Has elegido la opción 3");
                System.out.println("Introduce un radio válido (mayor que 0):");
                double radius = sc.nextDouble();
                double perimeter = Ejercicio3.calculateCirclePerimeter(radius);
                double area = Ejercicio3.calculateCircleArea(radius);
                System.out.println("El area del círculo es " + area + " y el perímetro es " + perimeter);
                break;
            case 4: // Conversor de Euros a Dólares y de Dólares a Euros
                System.out.println("Has elegido la opción 4");
                Ejercicio4.showMenu();
                int option2 = sc.nextInt();
                double money;
                switch (option2) {
                    case 1: // Conversor de Euros a Dólares
                        System.out.println("Introduce la cantidad de euros a convertir");
                        money = sc.nextInt();
                        System.out.println(money + " euros son " + Ejercicio4.euro2dollar(money) + " dólares");
                        break;
                    case 2: // Conversor de Dólares a Euros
                        System.out.println("Introduce la cantidad de dólares a convertir");
                        money = sc.nextInt();
                        System.out.println(money + " dólares son " + Ejercicio4.dollar2euro(money) + " euros");
                        break;
                    case 3: // Salir
                        System.out.println("Gracias por usar el conversor de divisas de Hazard");
                        break;
                }
                break;
            case 5: // Tabla de multiplicar de 1 número del 1 al 10
                System.out.println("Has elegido la opción 5");
                System.out.println("Introduce el número del que deseas saber la tabla de multiplicar");
                int num2 = sc.nextInt();
                Ejercicio5.TablaDeMultiplicar(num2);
                break;
            case 6: // Tabla de multiplicar del 1 al 10
                System.out.println("Has elegido la opción 6");
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Tabla de multiplicar del " + i);
                    Ejercicio5.TablaDeMultiplicar(i);
                }
                break;
            case 7: // Comprobador de números primos
                System.out.println("Has elegido la opción 7");
                System.out.println("Introduce un número entero positivo (0 para salir):");
                int num3 = sc.nextInt();
                if (Ejercicio7.esPrimo(num3)) {
                    System.out.println(num3 + " es un número primo.");
                    } else {
                    System.out.println(num3 + " no es un número primo.");
                }
                break;
            case 8: // Comprobador de fechas
                System.out.println("Has elegido la opción 8");
                System.out.println("Bienvenido al comprobador de fechas");
                Scanner sc2 = new Scanner(System.in);

                System.out.println("Introduce el día:");
                int dia = sc2.nextInt();

                System.out.println("Introduce el mes:");
                int mes = sc2.nextInt();

                System.out.println("Introduce el año:");
                int anio = sc2.nextInt();

                if (fechaCorrecta(dia, mes, anio)) {
                    System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " es correcta.");
                } else {
                    System.out.println("La fecha " + dia + "/" + mes + "/" + anio + " no es correcta.");
                }

                sc2.close();
                break;
            case 9: // Dibujar triángulos
                System.out.println("Has elegido la opción 9");
                System.out.println("Bienvenido al constructor de triangulos");
                System.out.println("Introduce un carácter");
                char caracter = sc.next().charAt(0);
                System.out.println("Introduce el número de líneas del triángulo");
                int numLineas = sc.nextInt();
                dibujarTriangulo(caracter, numLineas);
                break;
            case 0: // Salir
                System.out.println("Gracias por usar el menú de ejercicios de Hazard");
                System.out.println("\uD835\uDCD7\uD835\uDCEE\uD835\uDCEC\uD835\uDCF1\uD835\uDCF8 \uD835\uDCF9\uD835\uDCF8\uD835\uDCFB \uD835\uDCD7\uD835\uDCEA\uD835\uDD03\uD835\uDCEA\uD835\uDCFB\uD835\uDCED");


                }

    }

}
