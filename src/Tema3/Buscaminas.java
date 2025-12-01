package Tema3;

import java.util.Random;
import java.util.Scanner;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

public class Buscaminas {

    private static final int TAMANO_TABLERO = 20;
    private static final int NUMERO_MINAS = 6;
    private static final int MINA = 9; // Usaremos el 9 para representar una mina
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] tablero = crearTablero();
        boolean[] revelado = new boolean[TAMANO_TABLERO];
        int casillasSinMinas = TAMANO_TABLERO - NUMERO_MINAS;
        int casillasReveladas = 0;

        System.out.println("¡Bienvenido al Buscaminas!");

        while (true) {
            imprimirTablero(tablero, revelado);
            System.out.print("Elige una posición (1-" + TAMANO_TABLERO + "): ");
            int pos = sc.nextInt() - 1;

            if (pos < 0 || pos >= TAMANO_TABLERO || revelado[pos]) {
                System.out.println("Posición no válida o ya revelada.");
                continue;
            }

            if (tablero[pos] == MINA) {
                System.out.println("¡BOOM! Has encontrado una mina. Fin del juego.");
                revelarTodo(tablero);
                break;
            } else {
                revelado[pos] = true;
                casillasReveladas++;
                System.out.println("¡Seguro! Hay " + tablero[pos] + " minas alrededor.");
            }

            if (casillasReveladas == casillasSinMinas) {
                System.out.println("¡Felicidades! Has despejado el campo de minas. ¡Has ganado!");
                revelarTodo(tablero);
                break;
            }
        }
        sc.close();
    }

    public static int[] crearTablero() {
        int[] tablero = new int[TAMANO_TABLERO];
        Random random = new Random();

        // 1. Colocar las minas
        int minasColocadas = 0;
        while (minasColocadas < NUMERO_MINAS) {
            int pos = random.nextInt(TAMANO_TABLERO);
            if (tablero[pos] != MINA) {
                tablero[pos] = MINA;
                minasColocadas++;
            }
        }

        // 2. Calcular las pistas
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            if (tablero[i] != MINA) {
                int minasAlrededor = 0;
                // Comprobar la casilla de la izquierda
                if (i > 0 && tablero[i - 1] == MINA) {
                    minasAlrededor++;
                }
                // Comprobar la casilla de la derecha
                if (i < TAMANO_TABLERO - 1 && tablero[i + 1] == MINA) {
                    minasAlrededor++;
                }
                tablero[i] = minasAlrededor;
            }
        }
        return tablero;
    }

    public static void imprimirTablero(int[] tablero, boolean[] revelado) {
        System.out.println("---------------------------------");
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            if (revelado[i]) {
                System.out.print("[" + tablero[i] + "]\t");
            } else {
                System.out.print("[?]\t");
            }
        }
        System.out.println("\n---------------------------------");
    }
    
    public static void revelarTodo(int[] tablero) {
        System.out.println("Tablero final:");
        System.out.println("---------------------------------");
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            if(tablero[i] == MINA) {
                 System.out.print("[*]\t");
            } else {
                 System.out.print("[" + tablero[i] + "]\t");
            }
        }
         System.out.println("\n---------------------------------");
    }
}