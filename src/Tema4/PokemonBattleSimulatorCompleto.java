package Tema4;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PokemonBattleSimulatorCompleto {

    private static Scanner sc = new Scanner(System.in);
    private static ThreadLocalRandom rand = ThreadLocalRandom.current();

    // Matriz de efectividad de tipos (Simplificada para el ejemplo, expandible)
    private static final String[] TYPES = {"Normal", "Electrico", "Fuego", "Agua", "Planta", "Roca", "Volador", "Psiquico", "Hielo", "Tierra", "Veneno", "Fantasma", "Dragon"};
    // Se debería expandir la matriz completa 18x18 o 15x15 para Gen 1
    // Por brevedad, usaremos una función lógica simplificada o una matriz parcial
    
    public static void main(String[] args) {
        showTitleAndRules();

        Pokemon p1 = selectPokemon(1);
        customizeMoves(p1);
        
        Pokemon p2 = selectPokemon(2);
        boolean isP2AI = askIfAI();
        if (!isP2AI) {
            customizeMoves(p2);
        }

        battleLoop(p1, p2, isP2AI);
    }

    private static void showTitleAndRules() {
        System.out.println("*************************************************");
        System.out.println("   POKEMON BATTLE SIMULATOR - EDICION COMPLETA   ");
        System.out.println("*************************************************");
        System.out.println("Presiona Enter para continuar...");
        sc.nextLine();
        System.out.println("Reglas: Combate por turnos, estados alterados (Parálisis, Veneno, etc.), y selección de movimientos.");
    }

    private static boolean askIfAI() {
        System.out.println("¿Quieres que el Jugador 2 sea controlado por la IA? (S/N)");
        String response = sc.nextLine();
        return response.equalsIgnoreCase("S");
    }

    private static Pokemon selectPokemon(int playerNum) {
        while (true) {
            System.out.println("\nJugador " + playerNum + ", elige tu Pokemon (Escribe el nombre, ej: Charizard, Mewtwo, Gengar):");
            System.out.println("Opciones disponibles (ejemplo): Bulbasaur, Charmander, Squirtle, Pikachu, Snorlax, Dragonite, Mewtwo...");
            String name = sc.nextLine();
            
            Pokemon p = Pokedex.getPokemonByName(name);
            if (p != null) {
                System.out.println("Has elegido a " + p.getName() + "!");
                return p;
            } else {
                System.out.println("Pokemon no encontrado en la base de datos. Inténtalo de nuevo.");
            }
        }
    }
    
    private static void customizeMoves(Pokemon p) {
        System.out.println("\n¿Quieres personalizar los movimientos de " + p.getName() + "? (S/N)");
        if (!sc.nextLine().equalsIgnoreCase("S")) return;

        List<Move> pool = p.getMovePool();
        System.out.println("Movimientos disponibles:");
        for (int i = 0; i < pool.size(); i++) {
            System.out.println((i + 1) + ". " + pool.get(i).getName() + " (" + pool.get(i).getType() + ")");
        }

        System.out.println("Elige 4 movimientos introduciendo sus números separados por espacio (ej: 1 2 3 4):");
        // Lógica simple de selección
        try {
            String[] parts = sc.nextLine().split(" ");
            for (int i = 0; i < 4 && i < parts.length; i++) {
                int moveIdx = Integer.parseInt(parts[i]) - 1;
                if (moveIdx >= 0 && moveIdx < pool.size()) {
                    p.setMove(i, pool.get(moveIdx));
                }
            }
            System.out.println("Movimientos actualizados.");
        } catch (Exception e) {
            System.out.println("Error al leer movimientos. Se mantendrán los por defecto.");
        }
    }

    private static void battleLoop(Pokemon p1, Pokemon p2, boolean isP2AI) {
        System.out.println("\n¡COMIENZA EL COMBATE!");
        
        while (p1.getHpCurrent() > 0 && p2.getHpCurrent() > 0) {
            // Check Status Effects Pre-Turn (Paralysis speed drop handled in speed check, Burn damage handled end turn)
            
            // Determine order
            boolean p1GoesFirst = determineOrder(p1, p2);
            
            p1.resetTurnStatus();
            p2.resetTurnStatus();
            
            if (p1GoesFirst) {
                if (canMove(p1)) executeTurn(p1, p2, false);
                if (p2.getHpCurrent() <= 0) break;
                if (canMove(p2)) executeTurn(p2, p1, isP2AI);
                if (p1.getHpCurrent() <= 0) break;
            } else {
                if (canMove(p2)) executeTurn(p2, p1, isP2AI);
                if (p1.getHpCurrent() <= 0) break;
                if (canMove(p1)) executeTurn(p1, p2, false);
                if (p2.getHpCurrent() <= 0) break;
            }
            
            // End of turn effects (Burn, Poison)
            applyEndTurnEffects(p1);
            if (p1.getHpCurrent() <= 0) break;
            applyEndTurnEffects(p2);
            if (p2.getHpCurrent() <= 0) break;

            printHealthBars(p1, p2);
            System.out.println("Presiona Enter para siguiente turno...");
            sc.nextLine();
        }
        
        declareWinner(p1, p2);
    }
    
    private static boolean determineOrder(Pokemon p1, Pokemon p2) {
        int s1 = p1.getSpeed();
        int s2 = p2.getSpeed();
        
        if (p1.getStatusCondition().equals("PAR")) s1 /= 4; // Parálisis reduce velocidad 75% en Gen 1 (o 50% en modernas)
        if (p2.getStatusCondition().equals("PAR")) s2 /= 4;
        
        if (s1 > s2) return true;
        if (s2 > s1) return false;
        return rand.nextBoolean();
    }
    
    private static boolean canMove(Pokemon p) {
        if (p.getHpCurrent() <= 0) return false;
        
        if (p.getStatusCondition().equals("FRZ")) {
            if (rand.nextDouble() < 0.2) { // 20% chance to thaw
                System.out.println(p.getName() + " se ha descongelado!");
                p.setStatusCondition("NONE");
            } else {
                System.out.println(p.getName() + " está congelado y no puede moverse!");
                return false;
            }
        }
        
        if (p.getStatusCondition().equals("SLP")) {
            if (p.getSleepTurns() > 0) {
                p.setSleepTurns(p.getSleepTurns() - 1);
                System.out.println(p.getName() + " está dormido.");
                return false;
            } else {
                System.out.println(p.getName() + " se despertó!");
                p.setStatusCondition("NONE");
            }
        }
        
        if (p.getStatusCondition().equals("PAR")) {
            if (rand.nextDouble() < 0.25) {
                System.out.println(p.getName() + " está paralizado y no puede moverse!");
                return false;
            }
        }
        
        return true;
    }
    
    private static void applyEndTurnEffects(Pokemon p) {
        if (p.getStatusCondition().equals("BRN")) {
            int dmg = p.getHpMax() / 16;
            if (dmg < 1) dmg = 1;
            p.setHpCurrent(p.getHpCurrent() - dmg);
            System.out.println(p.getName() + " sufre daño por quemadura!");
        }
        if (p.getStatusCondition().equals("PSN")) {
            int dmg = p.getHpMax() / 8; // Toxic simple logic
            if (dmg < 1) dmg = 1;
            p.setHpCurrent(p.getHpCurrent() - dmg);
            System.out.println(p.getName() + " sufre daño por veneno!");
        }
    }

    private static void executeTurn(Pokemon attacker, Pokemon defender, boolean isAI) {
        System.out.println("\nTurno de " + attacker.getName());
        Move selectedMove = null;

        if (isAI) {
            // IA Simple: Elige un movimiento aleatorio válido
            Move[] moves = attacker.getMoves();
            int idx = rand.nextInt(4);
            while (moves[idx] == null) idx = rand.nextInt(4);
            selectedMove = moves[idx];
            System.out.println("La IA elige " + selectedMove.getName());
        } else {
            System.out.println("Elige un movimiento:");
            Move[] moves = attacker.getMoves();
            for (int i = 0; i < 4; i++) {
                if (moves[i] != null) {
                    System.out.println((i + 1) + ". " + moves[i].getName() + " (" + moves[i].getType() + "/" + moves[i].getCategory() + ") PP: " + moves[i].getPp());
                } else {
                    System.out.println((i + 1) + ". ---");
                }
            }
            
            int choice = -1;
            while (choice < 0 || choice > 3 || moves[choice] == null) {
                System.out.print("Opción (1-4): ");
                try {
                    choice = Integer.parseInt(sc.nextLine()) - 1;
                } catch (Exception e) {}
            }
            selectedMove = moves[choice];
        }
        
        // Check PP
        if (selectedMove.getPp() <= 0) {
            System.out.println("¡No quedan PP para este movimiento!");
            System.out.println(attacker.getName() + " usó Combate (Struggle)!");
            // Implementar struggle logic o perder turno
            return;
        }
        selectedMove.decrementPp();

        // Check Accuracy
        if (rand.nextInt(100) >= selectedMove.getAccuracy()) {
            System.out.println(attacker.getName() + " usó " + selectedMove.getName() + " pero falló!");
            return;
        }

        // Check Protection
        if (defender.isProtectedThisTurn() && !selectedMove.getCategory().equals("Estado")) {
            System.out.println(defender.getName() + " se protegió del ataque!");
            return;
        }

        // Execute Move
        if (selectedMove.getCategory().equals("Estado")) {
            executeStatusMove(attacker, defender, selectedMove);
        } else {
            executeDamageMove(attacker, defender, selectedMove);
        }
    }
    
    private static void executeStatusMove(Pokemon attacker, Pokemon defender, Move move) {
        System.out.println(attacker.getName() + " usó " + move.getName() + "!");
        
        String effect = move.getEffect();
        if (effect.equals("HEAL")) {
            int heal = attacker.getHpMax() / 2;
            attacker.setHpCurrent(attacker.getHpCurrent() + heal);
            System.out.println(attacker.getName() + " recuperó salud.");
        } else if (effect.equals("PROTECT")) {
            attacker.setProtectedThisTurn(true);
            System.out.println(attacker.getName() + " se está protegiendo.");
        } else if (!effect.equals("NONE")) {
            if (!defender.getStatusCondition().equals("NONE")) {
                System.out.println("¡Pero falló! " + defender.getName() + " ya tiene un estado alterado.");
            } else {
                // Check type immunity (e.g. Electric types can't be paralyzed by Thunder Wave)
                // Simplified check
                defender.setStatusCondition(effect);
                if (effect.equals("SLP")) defender.setSleepTurns(rand.nextInt(3) + 1);
                System.out.println(defender.getName() + " ha sufrido " + effect + "!");
            }
        }
    }
    
    private static void executeDamageMove(Pokemon attacker, Pokemon defender, Move move) {
        System.out.println(attacker.getName() + " usó " + move.getName() + "!");
        
        // Damage Calc
        int level = 50; // Fixed level
        int a = move.getCategory().equals("Fisico") ? attacker.getAttack() : attacker.getSpAttack();
        if (attacker.getStatusCondition().equals("BRN") && move.getCategory().equals("Fisico")) a /= 2; // Burn halves attack
        
        int d = move.getCategory().equals("Fisico") ? defender.getDefense() : defender.getSpDefense();
        int power = move.getPower();
        
        double stab = attacker.hasType(move.getType()) ? 1.5 : 1.0;
        double typeEff = getEffectiveness(move.getType(), defender);
        double random = rand.nextDouble(0.85, 1.0);
        double crit = (rand.nextInt(16) == 0) ? 1.5 : 1.0; // Gen 2+ crit is 1.5x? Gen 1 is 2x based on speed. Using 1.5
        
        if (crit > 1.0) System.out.println("¡Un golpe crítico!");
        
        int damage = (int) (((((2 * level / 5.0 + 2) * power * a / d) / 50.0) + 2) * stab * typeEff * random * crit);
        if (damage < 1) damage = 1;
        
        defender.setHpCurrent(defender.getHpCurrent() - damage);
        
        if (typeEff > 1.0) System.out.println("¡Es muy eficaz!");
        if (typeEff < 1.0 && typeEff > 0) System.out.println("No es muy eficaz...");
        if (typeEff == 0) System.out.println("No afecta a " + defender.getName() + "...");
        
        System.out.println("Causó " + damage + " puntos de daño.");
        
        // Secondary Effects (e.g. Flamethrower burn chance)
        if (move.getEffectChance() > 0 && rand.nextDouble() < move.getEffectChance()) {
            if (defender.getStatusCondition().equals("NONE") && defender.getHpCurrent() > 0) {
                 defender.setStatusCondition(move.getEffect());
                 System.out.println(defender.getName() + " sufrió " + move.getEffect() + " por el efecto secundario!");
            }
        }
    }
    
    private static double getEffectiveness(String moveType, Pokemon defender) {
        double multiplier = getTypeMultiplier(moveType, defender.getType1());
        if (defender.getType2() != null) {
            multiplier *= getTypeMultiplier(moveType, defender.getType2());
        }
        return multiplier;
    }
    
    // Simplified Type Chart Logic
    private static double getTypeMultiplier(String atk, String def) {
        if (atk.equals("Normal") && def.equals("Fantasma")) return 0.0;
        if (atk.equals("Fantasma") && def.equals("Normal")) return 0.0;
        if (atk.equals("Tierra") && def.equals("Volador")) return 0.0;
        if (atk.equals("Electrico") && def.equals("Tierra")) return 0.0;
        
        if (atk.equals("Fuego")) {
            if (def.equals("Planta") || def.equals("Hielo") || def.equals("Bicho")) return 2.0;
            if (def.equals("Fuego") || def.equals("Agua") || def.equals("Roca") || def.equals("Dragon")) return 0.5;
        }
        if (atk.equals("Agua")) {
            if (def.equals("Fuego") || def.equals("Tierra") || def.equals("Roca")) return 2.0;
            if (def.equals("Agua") || def.equals("Planta") || def.equals("Dragon")) return 0.5;
        }
        if (atk.equals("Electrico")) {
            if (def.equals("Agua") || def.equals("Volador")) return 2.0;
            if (def.equals("Electrico") || def.equals("Planta") || def.equals("Dragon")) return 0.5;
        }
        if (atk.equals("Planta")) {
            if (def.equals("Agua") || def.equals("Tierra") || def.equals("Roca")) return 2.0;
            if (def.equals("Fuego") || def.equals("Planta") || def.equals("Veneno") || def.equals("Volador") || def.equals("Bicho") || def.equals("Dragon")) return 0.5;
        }
        // ... Add more interactions as needed
        
        return 1.0;
    }

    private static void printHealthBars(Pokemon p1, Pokemon p2) {
        System.out.println("-----------------------------------------------------");
        System.out.println("J1: " + p1.getName() + " [" + p1.getStatusCondition() + "] " + p1.getHpCurrent() + "/" + p1.getHpMax());
        System.out.println("J2: " + p2.getName() + " [" + p2.getStatusCondition() + "] " + p2.getHpCurrent() + "/" + p2.getHpMax());
        System.out.println("-----------------------------------------------------");
    }
    
    private static void declareWinner(Pokemon p1, Pokemon p2) {
        System.out.println("\n****************************************");
        if (p1.getHpCurrent() > 0) {
            System.out.println("¡El ganador es el Jugador 1 con " + p1.getName() + "!");
        } else {
            System.out.println("¡El ganador es el Jugador 2 con " + p2.getName() + "!");
        }
        System.out.println("****************************************");
    }
}
