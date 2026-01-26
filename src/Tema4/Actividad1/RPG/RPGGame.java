package Tema4.Actividad1.RPG;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class RPGGame {

    private static final int enemyMinCount = 1;
    private static final int enemyMaxCount = 3;
    private static final double chanceEnemyFlee = 0.10;
    private static final double chanceRest = 0.001; // 0.1%
    private static final double chancePotion = 0.10; // 10%

    // Colores ANSI para consola
    public static final String ansiReset = "\u001B[0m";
    public static final String ansiRed = "\u001B[31m";
    public static final String ansiGreen = "\u001B[32m";
    public static final String ansiYellow = "\u001B[33m";
    public static final String ansiBlue = "\u001B[34m";
    public static final String ansiPurple = "\u001B[35m";
    public static final String ansiCyan = "\u001B[36m";
    public static final String ansiBold = "\u001B[1m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        printHeader();
        System.out.print(ansiCyan + "Introduce el nombre de tu héroe: " + ansiReset);
        String heroName = sc.nextLine();

        // Crear héroe principal (Stats iniciales)
        Hero player = new Hero(heroName, 100, 20, 5);
        System.out.println(ansiGreen + "\n¡" + player.getName() + " está listo para la batalla!" + ansiReset);
        System.out.println(player);

        int hordeCount = 0;

        // Bucle principal del juego
        while (player.isAlive()) {
            hordeCount++;
            printHordeHeader(hordeCount);

            // Generar enemigos (1 a 3)
            int numEnemies = rand.nextInt(enemyMaxCount - enemyMinCount + 1) + enemyMinCount;
            ArrayList<Hero> enemies = new ArrayList<>();

            for (int i = 0; i < numEnemies; i++) {
                // Enemigos más débiles que el jugador
                enemies.add(new Hero("Goblin " + (i + 1), 50, 10, 2));
            }

            System.out.println(ansiRed + "¡Aparecen " + numEnemies + " enemigos!" + ansiReset);

            // Bucle de combate de la horda
            while (player.isAlive() && !enemies.isEmpty()) {
                
                // Turno del Jugador
                // Atacamos al primer enemigo de la lista
                Hero target = enemies.get(0);
                System.out.print(ansiBlue + ">> " + ansiReset); // Indicador de turno jugador
                player.attack(target);

                if (!target.isAlive()) {
                    System.out.println(ansiYellow + "   ☠ " + target.getName() + " ha sido derrotado." + ansiReset);
                    enemies.remove(0);
                }

                // Turno de los Enemigos
                Iterator<Hero> it = enemies.iterator();
                while (it.hasNext()) {
                    Hero enemy = it.next();
                    
                    // Probabilidad de huir (10%)
                    if (rand.nextDouble() < chanceEnemyFlee) {
                        System.out.println(ansiPurple + "   💨 " + enemy.getName() + " ha huido de la batalla cobardemente." + ansiReset);
                        it.remove();
                        continue; // Pasa al siguiente enemigo
                    }

                    // Si no huye, ataca
                    System.out.print(ansiRed + "   << " + ansiReset); // Indicador turno enemigo
                    enemy.attack(player);
                    if (!player.isAlive()) {
                        break; // Jugador muerto, fin del combate
                    }
                }
                
                // Pequeña pausa para leer el combate
                try {
                    Thread.sleep(800); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (!player.isAlive()) {
                System.out.println(ansiRed + "\n" + player.getName() + " ha caído en combate..." + ansiReset);
                break;
            }

            System.out.println(ansiGreen + "\n¡Horda #" + hordeCount + " superada!" + ansiReset);
            System.out.println("Estado actual: " + player);

            // Eventos post-horda
            // Probabilidad de descansar (0.1%)
            if (rand.nextDouble() < chanceRest) {
                System.out.println(ansiCyan + "✨ ¡Has encontrado un lugar seguro! ✨" + ansiReset);
                player.rest();
            }

            // Probabilidad de poción (10%)
            if (rand.nextDouble() < chancePotion) {
                System.out.println(ansiCyan + "🧪 ¡Has encontrado una poción entre los restos! 🧪" + ansiReset);
                player.drinkPotion();
            }

            System.out.println("Esperando a la siguiente horda...");
            try {
                Thread.sleep(1500); // Espera un poco más larga entre hordas
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        printGameOver(hordeCount - 1);
        
        sc.close();
    }

    private static void printHeader() {
        System.out.println(ansiBold + "========================================" + ansiReset);
        System.out.println(ansiBold + "       ⚔️  JUEGO DE ROL ÉPICO  ⚔️       " + ansiReset);
        System.out.println(ansiBold + "========================================" + ansiReset);
    }

    private static void printHordeHeader(int horde) {
        System.out.println("\n" + ansiYellow + "╔══════════════════════════════════════╗");
        System.out.println("║              HORDA #" + String.format("%-3d", horde) + "              ║");
        System.out.println("╚══════════════════════════════════════╝" + ansiReset);
    }

    private static void printGameOver(int hordesSurvived) {
        System.out.println("\n" + ansiRed + "****************************************");
        System.out.println("              GAME OVER                 ");
        System.out.println("****************************************" + ansiReset);
        System.out.println("Sobreviviste a " + ansiBold + hordesSurvived + ansiReset + " hordas completas.");
    }
}
