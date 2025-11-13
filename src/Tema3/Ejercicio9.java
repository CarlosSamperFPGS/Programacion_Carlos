package Tema3;

//-------------------------------------------------------------------------------
// Escribe un procedimiento que muestre por pantalla un triángulo como el
// que hay a continuación. Recibirá 2 parámetros: el carácter y el número
// de líneas del triángulo.
//-------------------------------------------------------------------------------

import java.util.Scanner;

public class Ejercicio9 {
    // Procedimiento para dibujar el triángulo en árbol
    public static void dibujarTriangulo(char caracter, int numLineas) {
        for (int i = 1; i <= numLineas; i++) {
            // Imprimir espacios en blanco a la izquierda
            for (int j = 1; j <= numLineas - i; j++) {
                System.out.print(" ");
            }
            // Imprimir el carácter
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print(caracter);
            }
            // Salto de línea
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce un carácter");
        char caracter = sc.next().charAt(0);
        System.out.println("Introduce el número de líneas del triángulo");
        int numLineas = sc.nextInt();
        dibujarTriangulo(caracter, numLineas);
    }
}

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭