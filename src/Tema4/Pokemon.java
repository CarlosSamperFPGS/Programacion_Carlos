package Tema4;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    private String name;
    private String type1;
    private String type2; // Puede ser null
    private int hpMax;
    private int hpCurrent;
    private int attack;
    private int defense;
    private int spAttack;
    private int spDefense;
    private int speed;
    private Move[] moves; // 4 movimientos activos
    private List<Move> movePool; // Todos los movimientos posibles
    
    // Estado
    private String statusCondition; // "NONE", "PAR", "BRN", "PSN", "SLP", "FRZ"
    private int sleepTurns;
    private boolean protectedThisTurn;
    private boolean usedProtectLastTurn;
    private double protectProbability;

    public Pokemon(String name, String type1, String type2, int hp, int attack, int defense, int spAttack, int spDefense, int speed) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.hpMax = hp * 2 + 110; // Formula aproximada nivel 100 o ajustada para el juego
        this.hpCurrent = this.hpMax;
        this.attack = attack;
        this.defense = defense;
        this.spAttack = spAttack;
        this.spDefense = spDefense;
        this.speed = speed;
        this.moves = new Move[4];
        this.movePool = new ArrayList<>();
        this.statusCondition = "NONE";
        this.protectedThisTurn = false;
        this.usedProtectLastTurn = false;
        this.protectProbability = 1.0;
    }

    // Getters y Setters básicos
    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public int getHpMax() { return hpMax; }
    public int getHpCurrent() { return hpCurrent; }
    public void setHpCurrent(int hp) { 
        this.hpCurrent = Math.max(0, Math.min(hp, hpMax)); 
    }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getSpAttack() { return spAttack; }
    public int getSpDefense() { return spDefense; }
    public int getSpeed() { return speed; }
    public Move[] getMoves() { return moves; }
    public List<Move> getMovePool() { return movePool; }
    public String getStatusCondition() { return statusCondition; }
    public void setStatusCondition(String status) { this.statusCondition = status; }
    
    public boolean isProtectedThisTurn() { return protectedThisTurn; }
    public void setProtectedThisTurn(boolean val) { this.protectedThisTurn = val; }
    public boolean isUsedProtectLastTurn() { return usedProtectLastTurn; }
    public void setUsedProtectLastTurn(boolean val) { this.usedProtectLastTurn = val; }
    public double getProtectProbability() { return protectProbability; }
    public void setProtectProbability(double val) { this.protectProbability = val; }
    public int getSleepTurns() { return sleepTurns; }
    public void setSleepTurns(int turns) { this.sleepTurns = turns; }

    public void addMoveToPool(Move move) {
        movePool.add(move);
    }

    public void setMove(int index, Move move) {
        if (index >= 0 && index < 4) {
            moves[index] = move;
        }
    }
    
    // Asigna los primeros 4 movimientos del pool por defecto
    public void setDefaultMoves() {
        for (int i = 0; i < 4 && i < movePool.size(); i++) {
            moves[i] = movePool.get(i);
        }
    }

    public void resetTurnStatus() {
        this.protectedThisTurn = false;
    }
    
    public boolean hasType(String type) {
        return type.equals(type1) || type.equals(type2);
    }
}
