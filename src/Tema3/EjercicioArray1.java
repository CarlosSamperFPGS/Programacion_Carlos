package Tema3;

import java.util.Scanner;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

public class EjercicioArray1 {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] vector1 = null;
        int[] vector2 = null;
        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    vector1 = leerVector("primer");
                    break;
                case 2:
                    vector2 = leerVector("segundo");
                    break;
                case 3:
                    if (vector1 != null) MyArray.imprimirArray(vector1);
                    else System.out.println("El primer vector no ha sido introducido.");
                    break;
                case 4:
                    if (vector1 != null) System.out.println("Máximo: " + MyArray.maximo(vector1));
                    else System.out.println("El vector no ha sido introducido.");
                    break;
                case 5:
                    if (vector1 != null) System.out.println("Mínimo: " + MyArray.minimo(vector1));
                    else System.out.println("El vector no ha sido introducido.");
                    break;
                case 6:
                    if (vector1 != null) System.out.println("Media: " + MyArray.media(vector1));
                    else System.out.println("El vector no ha sido introducido.");
                    break;
                case 7:
                    if (vector1 != null) {
                        System.out.print("Introduce el elemento a buscar: ");
                        int elemento = sc.nextInt();
                        System.out.println("¿Existe? " + MyArray.existe(vector1, elemento));
                    } else {
                        System.out.println("El vector no ha sido introducido.");
                    }
                    break;
                case 8:
                    if (vector1 != null && vector2 != null) {
                        int[] suma = MyArray.sumaVectores(vector1, vector2);
                        if (suma != null) {
                            System.out.print("Suma: ");
                            MyArray.imprimirArray(suma);
                        } else {
                            System.out.println("Los vectores no tienen la misma longitud.");
                        }
                    } else {
                        System.out.println("Debes introducir ambos vectores.");
                    }
                    break;
                case 9:
                     if (vector1 != null && vector2 != null) {
                        int[] resta = MyArray.restaVectores(vector1, vector2);
                        if (resta != null) {
                            System.out.print("Resta: ");
                            MyArray.imprimirArray(resta);
                        } else {
                            System.out.println("Los vectores no tienen la misma longitud.");
                        }
                    } else {
                        System.out.println("Debes introducir ambos vectores.");
                    }
                    break;
                case 10:
                     if (vector1 != null && vector2 != null) {
                        if(vector1.length == vector2.length) {
                            System.out.println("Producto Escalar: " + MyArray.productoEscalar(vector1, vector2));
                        } else {
                             System.out.println("Los vectores no tienen la misma longitud.");
                        }
                    } else {
                        System.out.println("Debes introducir ambos vectores.");
                    }
                    break;
                case 11:
                    if (vector1 != null) {
                        int[] invertido = MyArray.invertirArrayFuncion(vector1);
                        System.out.print("Array invertido (función): ");
                        MyArray.imprimirArray(invertido);
                    } else {
                        System.out.println("El vector no ha sido introducido.");
                    }
                    break;
                case 12:
                    if (vector1 != null) {
                        MyArray.invertirArrayProcedimiento(vector1);
                        System.out.print("Array invertido (procedimiento): ");
                        MyArray.imprimirArray(vector1);
                    } else {
                        System.out.println("El vector no ha sido introducido.");
                    }
                    break;
                case 13:
                    if (vector1 != null) {
                        System.out.println("¿Es capicúa? " + MyArray.esCapicua(vector1));
                    } else {
                        System.out.println("El vector no ha sido introducido.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("\n----------------------------------\n");
        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("GESTOR DE VECTORES");
        System.out.println("1. Introducir primer vector");
        System.out.println("2. Introducir segundo vector");
        System.out.println("3. Imprimir vector 1");
        System.out.println("4. Ver máximo del vector 1");
        System.out.println("5. Ver mínimo del vector 1");
        System.out.println("6. Ver media del vector 1");
        System.out.println("7. Comprobar si existe un elemento en el vector 1");
        System.out.println("8. Sumar vectores");
        System.out.println("9. Restar vectores");
        System.out.println("10. Producto escalar de vectores");
        System.out.println("11. Invertir vector 1 (Función)");
        System.out.println("12. Invertir vector 1 (Procedimiento)");
        System.out.println("13. Comprobar si el vector 1 es capicúa");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    public static int[] leerVector(String ordinal) {
        System.out.print("Introduce el tamaño del " + ordinal + " vector: ");
        int tamano = sc.nextInt();
        int[] vector = new int[tamano];
        System.out.println("Introduce los " + tamano + " elementos del vector:");
        for (int i = 0; i < tamano; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            vector[i] = sc.nextInt();
        }
        return vector;
    }
}