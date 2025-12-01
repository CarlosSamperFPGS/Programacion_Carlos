package Tema3;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

public class BuscarParejas {

    private static final String[] ANIMALES = {"León", "Tigre", "Oso", "Gato", "Perro", "Loro", "Pez", "Rana", "Vaca", "Pollo"};
    private static final int TAMANO_TABLERO = 20;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] tablero = crearTableroAleatorio();
        boolean[] visibles = new boolean[TAMANO_TABLERO];
        int parejasEncontradas = 0;

        System.out.println("¡Bienvenido a 'Buscar Parejas'!");

        while (parejasEncontradas < ANIMALES.length) {
            imprimirTablero(tablero, visibles);

            int pos1 = pedirPosicion("primera");
            int pos2 = pedirPosicion("segunda");

            if (pos1 == pos2 || visibles[pos1] || visibles[pos2]) {
                System.out.println("Selección no válida. Elige dos posiciones diferentes y no reveladas.");
                continue;
            }

            if (tablero[pos1].equals(tablero[pos2])) {
                System.out.println("¡Pareja encontrada: " + tablero[pos1] + "!");
                visibles[pos1] = true;
                visibles[pos2] = true;
                parejasEncontradas++;
            } else {
                System.out.println("No son pareja. Eran un " + tablero[pos1] + " y un " + tablero[pos2] + ".");
                // Pausa para que el jugador memorice
                try {
                    Thread.sleep(2000); // Pausa de 2 segundos
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // "Limpiar" la pantalla
                for (int i = 0; i < 20; i++) System.out.println();
            }
        }

        System.out.println("\n¡Felicidades! Has encontrado todas las parejas.");
        imprimirTablero(tablero, visibles);
        scanner.close();
    }

    public static String[] crearTableroAleatorio() {
        List<String> listaAnimales = new ArrayList<>();
        for (String animal : ANIMALES) {
            listaAnimales.add(animal);
            listaAnimales.add(animal);
        }
        Collections.shuffle(listaAnimales);
        return listaAnimales.toArray(new String[0]);
    }

    public static void imprimirTablero(String[] tablero, boolean[] visibles) {
        System.out.println("---------------------------------");
        for (int i = 0; i < TAMANO_TABLERO; i++) {
            if (visibles[i]) {
                System.out.print("[" + tablero[i] + "]\t");
            } else {
                System.out.print("[" + (i + 1) + "]\t");
            }
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("---------------------------------");
    }

    public static int pedirPosicion(String ordinal) {
        int pos;
        while (true) {
            System.out.print("Elige la " + ordinal + " posición (1-" + TAMANO_TABLERO + "): ");
            pos = scanner.nextInt() - 1;
            if (pos >= 0 && pos < TAMANO_TABLERO) {
                break;
            } else {
                System.out.println("Posición no válida.");
            }
        }
        return pos;
    }
}