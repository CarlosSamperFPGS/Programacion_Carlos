package Tema3;

import java.util.Random;
import java.util.Scanner;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

public class AtrapaLaMosca {

    private static final int TAMANO_TABLERO = 15;
    private static Random random = new Random();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int[] tablero = new int[TAMANO_TABLERO];
        int posicionMosca = random.nextInt(TAMANO_TABLERO);
        tablero[posicionMosca] = 1; // 1 representa la mosca

        System.out.println("¡Bienvenido a 'Atrapa a la Mosca'!");
        System.out.println("Intenta adivinar en qué posición (1-" + TAMANO_TABLERO + ") se encuentra la mosca.");

        boolean atrapada = false;
        while (!atrapada) {
            System.out.print("Elige una posición: ");
            int intento = sc.nextInt() - 1; // Restamos 1 para ajustar al índice del array (0-14)

            if (intento < 0 || intento >= TAMANO_TABLERO) {
                System.out.println("Posición fuera de rango. Inténtalo de nuevo.");
                continue;
            }

            if (tablero[intento] == 1) {
                System.out.println("¡Felicidades! ¡Has atrapado a la mosca!");
                atrapada = true;
            } else {
                System.out.println("¡Fallaste!");
                // Comprobamos si el intento fue en una posición adyacente
                if (Math.abs(intento - posicionMosca) == 1) {
                    //TODO: adyacente es una posicion por delante y otra por detrás
                    System.out.println("¡Cerca! La mosca se ha asustado y ha cambiado de posición.");
                    // La mosca cambia de posición aleatoriamente
                    tablero[posicionMosca] = 0; // La mosca deja su posición actual
                    posicionMosca = random.nextInt(TAMANO_TABLERO);
                    tablero[posicionMosca] = 1; // La mosca se va a una nueva posición
                } else {
                    System.out.println("La mosca no se ha movido.");
                }
            }
        }
        sc.close();
    }
}