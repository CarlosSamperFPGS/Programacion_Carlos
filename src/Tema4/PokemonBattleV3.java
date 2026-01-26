package Tema4;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PokemonBattleV3 {

    private static Scanner sc = new Scanner(System.in);
    private static ThreadLocalRandom rand = ThreadLocalRandom.current();

    // Matriz de efectividad de tipos
    // Filas: Atacante, Columnas: Defensor
    // Indices: 0: Normal, 1: Electrico, 2: Fuego, 3: Agua, 4: Planta, 5: Roca, 6: Volador
    private static final String[] TYPES = {"Normal", "Electrico", "Fuego", "Agua", "Planta", "Roca", "Volador"};
    private static final double[][] TYPE_CHART = {
        // N    E    F    A    P    R    V
        {1.0, 1.0, 1.0, 1.0, 1.0, 0.5, 1.0}, // Normal
        {1.0, 0.5, 1.0, 2.0, 0.5, 0.5, 2.0}, // Electrico
        {1.0, 1.0, 0.5, 0.5, 2.0, 0.5, 1.0}, // Fuego
        {1.0, 1.0, 2.0, 0.5, 0.5, 2.0, 1.0}, // Agua
        {1.0, 1.0, 0.5, 2.0, 0.5, 2.0, 0.5}, // Planta
        {1.0, 1.0, 2.0, 1.0, 1.0, 1.0, 2.0}, // Roca (Simplificado)
        {1.0, 0.5, 1.0, 1.0, 2.0, 0.5, 1.0}  // Volador
    };

    public static void main(String[] args) {
        showTitleAndRules();

        Pokemon p1 = selectPokemon(1);
        Pokemon p2 = selectPokemon(2);

        // Check if player 2 should be AI controlled
        boolean isP2AI = askIfAI();

        battleLoop(p1, p2, isP2AI);
    }

    private static void showTitleAndRules() {
        System.out.println("****************************************");
        System.out.println("*****************************************");
        System.out.println("Bienvenido a Pokemon Battle Simulator V3");
        System.out.println("*****************************************");
        System.out.println("****************************************");
        System.out.println("Presiona Enter para continuar...");
        sc.nextLine();

        System.out.println("Hecho por Hazard");
        System.out.println("\n--- Reglas del Juego ---");
        System.out.println("1. Cada jugador elige un Pokémon de entre las opciones disponibles. También puedes crear tu Pokemon");
        System.out.println("2. Los Pokémon tienen estadísticas base de HP, Ataque, Defensa, Ataque Especial, Defensa Especial y Velocidad.");
        System.out.println("3. El combate se desarrolla por turnos hasta que uno de los Pokémon se debilite.");
        System.out.println("4. En cada turno, puedes elegir entre 4 movimientos.");
        System.out.println("5. El daño se calcula en base a las estadísticas y modificadores (Tabla de Tipos incluida).");
        System.out.println("\n¡Que empiece el combate!");
        System.out.println("Presiona Enter para continuar...");
        sc.nextLine();
    }

    private static boolean askIfAI() {
        System.out.println("¿Quieres que el Jugador 2 sea controlado por la IA? (S/N)");
        String response = sc.nextLine();
        return response.equalsIgnoreCase("S");
    }

    private static Pokemon selectPokemon(int playerNum) {
        System.out.println("\nJugador " + playerNum + ", elige tu Pokemon: Pikachu, Charmander, Squirtle, Bulbasaur, Geodude, Pidgey (o introduce otra cosa para crear el tuyo)");
        String choice = sc.nextLine();

        // Common moves
        Move tackle = new Move("Placaje", "Normal", "Fisico", 40);

        switch (choice) {
            case "Pikachu":
                return new Pokemon("Pikachu", "Electrico", null, 35, 55, 40, 50, 50, 90);
            case "Charmander":
                return new Pokemon("Charmander", "Fuego", null, 39, 52, 43, 60, 50, 65);
            case "Squirtle":
                return new Pokemon("Squirtle", "Agua", null, 44, 48, 65, 50, 64, 43);
            case "Bulbasaur":
                return new Pokemon("Bulbasaur", "Planta", "Veneno", 45, 49, 49, 65, 65, 45);
            case "Geodude":
                return new Pokemon("Geodude", "Roca", "Tierra", 40, 80, 100, 30, 30, 20);
            case "Pidgey":
                return new Pokemon("Pidgey", "Volador", "Normal", 40, 45, 40, 35, 35, 56);
            default:
                return createCustomPokemon(playerNum);
        }
    }

    private static Pokemon createCustomPokemon(int playerNum) {
        System.out.println("\n--- CREADOR DE POKÉMON (Jugador " + playerNum + ") ---");
        System.out.print("Introduce el nombre de tu Pokémon: ");
        String name = sc.nextLine();

        String type = "";
        boolean typeSelected = false;
        while (!typeSelected) {
            System.out.print("Elige su tipo (Electrico, Fuego, Agua, Planta, Roca, Volador): ");
            String inputType = sc.nextLine();
            if (getTypeIndex(inputType) != -1) {
                type = inputType;
                typeSelected = true;
            } else {
                System.out.println("Tipo no válido.");
            }
        }

        System.out.println("\nAhora distribuye 500 puntos entre las estadísticas (máximo 100 por stat).");
        int[] stats = new int[6];
        String[] statNames = {"HP", "Ataque", "Defensa", "Ataque Especial", "Defensa Especial", "Velocidad"};
        int pointsLeft = 500;

        for (int i = 0; i < 6; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.println("Puntos restantes: " + pointsLeft);
                System.out.print("Puntos para " + statNames[i] + ": ");
                try {
                    int points = Integer.parseInt(sc.nextLine());
                    if (points < 0 || points > 100) {
                        System.out.println("Error: Entre 0 y 100.");
                    } else if (points > pointsLeft) {
                        System.out.println("Error: No tienes suficientes puntos.");
                    } else if (i == 5 && points != pointsLeft) {
                        System.out.println("Error: Debes usar todos los puntos restantes en la última estadística.");
                    } else {
                        stats[i] = points;
                        pointsLeft -= points;
                        valid = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, introduce un número válido.");
                }
            }
        }

        Move tackle = new Move("Placaje", "Normal", "Fisico", 40);
        Move specialMove = new Move("Ataque Tipo", type, "Especial", 40);

        Pokemon custom = new Pokemon(name, type, null, stats[0], stats[1], stats[2], stats[3], stats[4], stats[5]);
        custom.setMove(0, tackle);
        custom.setMove(1, specialMove);
        return custom;
    }

    private static int getTypeIndex(String type) {
        for (int i = 0; i < TYPES.length; i++) {
            if (TYPES[i].equalsIgnoreCase(type)) {
                return i;
            }
        }
        return -1;
    }

    private static void battleLoop(Pokemon p1, Pokemon p2, boolean isP2AI) {
        // Asignar movimientos por defecto si no tienen
        if (p1.getMoves()[0] == null) assignDefaultMoves(p1);
        if (p2.getMoves()[0] == null) assignDefaultMoves(p2);

        boolean p1GoesFirst;

        if (p1.getSpeed() > p2.getSpeed()) {
            p1GoesFirst = true;
            System.out.println(p1.getName() + " es más rápido y atacará primero!");
        } else if (p2.getSpeed() > p1.getSpeed()) {
            p1GoesFirst = false;
            System.out.println(p2.getName() + " es más rápido y atacará primero!");
        } else {
            p1GoesFirst = rand.nextBoolean();
            System.out.println("¡Misma velocidad! " + (p1GoesFirst ? p1.getName() : p2.getName()) + " empieza.");
        }

        System.out.println("Presiona Enter para empezar el combate...");
        sc.nextLine();

        while (p1.getHpCurrent() > 0 && p2.getHpCurrent() > 0) {
            printHealthBars(p1, p2);

            p1.resetTurnStatus();
            p2.resetTurnStatus();

            if (p1GoesFirst) {
                executeTurn(p1, p2, false);
                if (p2.getHpCurrent() <= 0) break;
                executeTurn(p2, p1, isP2AI);
                if (p1.getHpCurrent() <= 0) break;
            } else {
                executeTurn(p2, p1, isP2AI);
                if (p1.getHpCurrent() <= 0) break;
                executeTurn(p1, p2, false);
                if (p2.getHpCurrent() <= 0) break;
            }

            System.out.println("\nPresiona Enter para pasar al siguiente turno...");
            sc.nextLine();
        }

        System.out.println("\n****************************************");
        System.out.println("*       EL COMBATE HA TERMINADO        *");
        System.out.println("****************************************");

        if (p1.getHpCurrent() > 0) {
            System.out.println("El ganador es el Jugador 1 con " + p1.getName() + "!");
        } else {
            System.out.println("El ganador es el Jugador 2 con " + p2.getName() + "!");
        }
    }

    private static void assignDefaultMoves(Pokemon p) {
        Move tackle = new Move("Placaje", "Normal", "Fisico", 40);
        Move special = new Move("Ataque Especial", p.getType1(), "Especial", 40);
        p.setMove(0, tackle);
        p.setMove(1, special);
    }

    private static void printHealthBars(Pokemon p1, Pokemon p2) {
        System.out.println("-----------------------------------------------------");
        printSingleHealthBar("Jugador 1", p1);
        System.out.println();
        printSingleHealthBar("Jugador 2", p2);
        System.out.println("-----------------------------------------------------");
    }

    private static void printSingleHealthBar(String label, Pokemon p) {
        System.out.println(label + ": " + p.getName());
        int totalBars = 20;
        double percentage = (double) p.getHpCurrent() / p.getHpMax();
        int filledBars = (int) (percentage * totalBars);
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < totalBars; i++) {
            bar.append(i < filledBars ? "#" : "-");
        }
        bar.append("] ").append(p.getHpCurrent()).append("/").append(p.getHpMax()).append(" PS");
        System.out.println(bar);
    }

    private static void executeTurn(Pokemon attacker, Pokemon defender, boolean isAI) {
        System.out.println("\nTurno de " + attacker.getName());
        int choice;

        if (isAI) {
            choice = decideAIMove(attacker, defender);
            System.out.println("La IA elige la opción " + choice);
        } else {
            System.out.println("1. Placaje");
            String move2Name = (attacker.getMoves()[1] != null) ? attacker.getMoves()[1].getName() : "---";
            System.out.println("2. " + move2Name);
            System.out.println("3. Proteccion");
            System.out.println("4. Recuperacion");
            System.out.print("Elige un movimiento (1-4): ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }
        }

        if (defender.isProtectedThisTurn() && (choice == 1 || choice == 2)) {
            System.out.println(defender.getName() + " se protegio! El ataque de " + attacker.getName() + " falla!");
            attacker.setUsedProtectLastTurn(false);
            attacker.setProtectProbability(1.0);
            return;
        }

        switch (choice) {
            case 1: // Placaje
            case 2: // Special Move
                Move move = (choice == 1) ? attacker.getMoves()[0] : attacker.getMoves()[1];
                if (move != null) {
                    performAttack(attacker, defender, move);
                } else {
                    System.out.println("Movimiento no disponible.");
                }
                attacker.setUsedProtectLastTurn(false);
                attacker.setProtectProbability(1.0);
                break;
            case 3: // Protection
                if (rand.nextDouble() < attacker.getProtectProbability()) {
                    System.out.println(attacker.getName() + " uso Proteccion!");
                    attacker.setProtectedThisTurn(true);
                    attacker.setUsedProtectLastTurn(true);
                    attacker.setProtectProbability(attacker.getProtectProbability() / 2.0);
                } else {
                    System.out.println("Pero " + attacker.getName() + " fallo al usar Proteccion!");
                    attacker.setUsedProtectLastTurn(false);
                    attacker.setProtectProbability(1.0);
                }
                break;
            case 4: // Recovery
                if (rand.nextDouble() < 0.9) {
                    int healAmount = attacker.getHpMax() / 2;
                    attacker.setHpCurrent(attacker.getHpCurrent() + healAmount);
                    System.out.println(attacker.getName() + " uso Recuperacion y recupero " + healAmount + " PS.");
                } else {
                    System.out.println("Pero " + attacker.getName() + " fallo al usar Recuperacion!");
                }
                attacker.setUsedProtectLastTurn(false);
                attacker.setProtectProbability(1.0);
                break;
            default:
                System.out.println("Eleccion no valida. " + attacker.getName() + " pierde el turno.");
                attacker.setUsedProtectLastTurn(false);
                attacker.setProtectProbability(1.0);
                break;
        }
    }

    private static int decideAIMove(Pokemon ai, Pokemon opponent) {
        // Simple AI Logic
        // If low health, try to recover
        if (ai.getHpCurrent() < ai.getHpMax() * 0.3) {
            if (rand.nextDouble() < 0.7) return 4; // 70% chance to heal if low
        }
        // If opponent is likely to attack strongly, maybe protect? (Random for now)
        if (rand.nextDouble() < 0.1) return 3;

        // Choose best attack
        // Calculate damage for move 1 and move 2 and pick the best one
        // For simplicity, just random attack or type advantage check could be added here
        // Let's just pick random attack for now to keep it simple but functional
        return rand.nextBoolean() ? 1 : 2;
    }

    private static void performAttack(Pokemon attacker, Pokemon defender, Move move) {
        System.out.println(attacker.getName() + " uso " + move.getName() + "!");

        int level = 50;
        int attackStat = move.getCategory().equals("Fisico") ? attacker.getAttack() : attacker.getSpAttack();
        int defenseStat = move.getCategory().equals("Fisico") ? defender.getDefense() : defender.getSpDefense();

        double stab = attacker.hasType(move.getType()) ? 1.5 : 1.0;
        double critical = (rand.nextInt(24) == 0) ? 1.5 : 1.0;
        if (critical > 1.0) System.out.println("Un golpe critico!");
        double randomMod = rand.nextDouble(0.85, 1.0);
        double effectiveness = getEffectiveness(move.getType(), defender.getType1());

        double damageCalc = (((((2.0 * level / 5.0) + 2.0) * move.getPower() * attackStat / defenseStat) / 50.0) + 2.0) * stab * critical * randomMod * effectiveness;
        int damage = (int) damageCalc;
        if (damage < 1) damage = 1;

        defender.setHpCurrent(defender.getHpCurrent() - damage);

        if (effectiveness == 2.0) System.out.println("Es muy eficaz!");
        else if (effectiveness == 0.5) System.out.println("No es muy eficaz...");

        System.out.println("Causo " + damage + " puntos de dano.");
    }

    private static double getEffectiveness(String moveType, String targetType) {
        int moveTypeIndex = getTypeIndex(moveType);
        int targetTypeIndex = getTypeIndex(targetType);

        if (moveTypeIndex != -1 && targetTypeIndex != -1) {
            return TYPE_CHART[moveTypeIndex][targetTypeIndex];
        }
        return 1.0;
    }
}
