package Tema3;

import java.util.Scanner;

// 𝓗𝓮𝓬𝓱𝓸 𝓹𝓸𝓻 𝓗𝓪𝔃𝓪𝓻𝓭

public class SimulacionWifi {

    private static final int NUMERO_HABITACIONES = 20;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("SIMULADOR DE COBERTURA WIFI");
        System.out.print("Introduce la habitación donde instalar el router (1-" + NUMERO_HABITACIONES + "): ");
        int habitacionRouter = sc.nextInt();

        System.out.print("Introduce la potencia de transmisión del router (1-6): ");
        int potenciaRouter = sc.nextInt();

        // Validamos las entradas
        if (habitacionRouter < 1 || habitacionRouter > NUMERO_HABITACIONES || potenciaRouter < 1 || potenciaRouter > 6) {
            System.out.println("Los valores introducidos no son válidos.");
            sc.close();
            return;
        }

        int[] cobertura = calcularCobertura(habitacionRouter - 1, potenciaRouter); // Ajustamos a índice 0

        System.out.println("\nMapa de cobertura WiFi:");
        MyArray.imprimirArray(cobertura);

        sc.close();
    }

    // Función para calcular la cobertura
    public static int[] calcularCobertura(int indiceRouter, int potencia) {
        int[] habitaciones = new int[NUMERO_HABITACIONES];

        // Rellenamos el array con la señal
        for (int i = 0; i < NUMERO_HABITACIONES; i++) {
            int distancia = Math.abs(i - indiceRouter);
            int senal = potencia - distancia;
            habitaciones[i] = Math.max(0, senal); // La señal no puede ser negativa
        }

        return habitaciones;
    }
}