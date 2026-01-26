package Tema3;

import java.util.Scanner;

/**
 * Esta clase contiene múltiples ejemplos para entender el funcionamiento de los arrays en Java.
 */
public class arrays {

    public static void main(String[] args) {

        //-------------------------------------------------------------------------------
        // 1. DECLARACIÓN E INICIALIZACIÓN DE UN ARRAY
        //-------------------------------------------------------------------------------
        // Un array es una colección de elementos del mismo tipo.
        // Aquí declaramos un array de enteros (int) y lo inicializamos con 5 valores.
        // Los índices del array van de 0 a 4.
        int[] numeros = {10, 20, 30, 40, 50};

        // También podemos declarar un array de Strings (cadenas de texto).
        String[] nombres = {"Ana", "Luis", "Marta"};


        //-------------------------------------------------------------------------------
        // 2. ACCESO A LOS ELEMENTOS DE UN ARRAY
        //-------------------------------------------------------------------------------
        // Para acceder a un elemento, usamos su índice entre corchetes [].
        // El primer elemento siempre está en el índice 0.
        System.out.println("El primer elemento del array de números es: " + numeros[0]); // Imprime 10
        System.out.println("El segundo nombre en el array de nombres es: " + nombres[1]); // Imprime "Luis"

        // La propiedad .length nos da el tamaño total del array.
        System.out.println("El tamaño del array de números es: " + numeros.length); // Imprime 5
        System.out.println("---------------------------------");


        //-------------------------------------------------------------------------------
        // 3. MODIFICAR ELEMENTOS DE UN ARRAY
        //-------------------------------------------------------------------------------
        // Podemos cambiar el valor de un elemento asignándole un nuevo valor.
        System.out.println("El valor original en la posición 2 es: " + numeros[2]); // Imprime 30
        numeros[2] = 35; // Cambiamos el valor en el índice 2
        System.out.println("El nuevo valor en la posición 2 es: " + numeros[2]); // Imprime 35
        System.out.println("---------------------------------");


        //-------------------------------------------------------------------------------
        // 4. RECORRER UN ARRAY CON UN BUCLE 'FOR' TRADICIONAL
        //-------------------------------------------------------------------------------
        // Este bucle es útil cuando necesitamos el índice para algo.
        System.out.println("Recorriendo el array de nombres con un bucle for:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Índice " + i + ": " + nombres[i]);
        }
        System.out.println("---------------------------------");


        //-------------------------------------------------------------------------------
        // 5. RECORRER UN ARRAY CON UN BUCLE 'FOR-EACH'
        //-------------------------------------------------------------------------------
        // Este bucle es más simple y legible si solo necesitas el valor de cada elemento.
        System.out.println("Recorriendo el array de números con un bucle for-each:");
        for (int numero : numeros) {
            System.out.println("Valor: " + numero);
        }
        System.out.println("---------------------------------");


        //-------------------------------------------------------------------------------
        // 6. DECLARAR UN ARRAY CON UN TAMAÑO Y LLENARLO DESPUÉS
        //-------------------------------------------------------------------------------
        // Creamos un array para 4 notas, pero sin valores iniciales.
        // Por defecto, los valores numéricos se inicializan a 0.
        double[] notas = new double[4];
        Scanner scanner = new Scanner(System.in);

        // Pedimos al usuario que introduzca las notas y las guardamos en el array.
        for (int i = 0; i < notas.length; i++) {
            System.out.print("Introduce la nota " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
        }

        // Mostramos las notas guardadas.
        System.out.println("Las notas introducidas son:");
        for (double nota : notas) {
            System.out.println(nota);
        }
        System.out.println("---------------------------------");


        //-------------------------------------------------------------------------------
        // 7. ARRAYS MULTIDIMENSIONALES (MATRICES)
        //-------------------------------------------------------------------------------
        // Un array de dos dimensiones es como una tabla o una matriz.
        // Aquí creamos una matriz de 2 filas y 3 columnas.
        int[][] matriz = {
            {1, 2, 3},  // Fila 0
            {4, 5, 6}   // Fila 1
        };

        // Para acceder a un elemento, necesitamos dos índices: [fila][columna].
        System.out.println("Elemento en la fila 1, columna 2: " + matriz[1][2]); // Imprime 6

        // Para recorrer una matriz, necesitamos bucles anidados.
        System.out.println("Recorriendo la matriz completa:");
        for (int i = 0; i < matriz.length; i++) { // Recorre las filas
            for (int j = 0; j < matriz[i].length; j++) { // Recorre las columnas de la fila actual
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(); // Salto de línea al final de cada fila
        }
        System.out.println("---------------------------------");
        
        scanner.close();
    }
}