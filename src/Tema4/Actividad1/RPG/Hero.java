package Tema4.Actividad1.RPG;

import java.util.Random;

public class Hero {

    // Constantes
    private static final int PotionHealAmount = 10;
    private static final int RestHealAmount = 50;
    private static final int XpPerAttack = 10;
    private static final int XpThresholdLevelUp = 50;
    private static final int LevelUpHealthBonus = 5;
    private static final int LevelUpStatBonus = 1;
    private static final int MinDamageCalc = 10;
    private static final int MinDamageDealt = 1;

    // Atributos
    private String name;
    private int level;
    private int health;
    private int maxHealth;
    private int experience;
    private int attack;
    private int defense;

    private Random random;

    // Constructores
    public Hero(String name, int maxHealth, int attack, int defense) {
        this.name = name;
        this.level = 1;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.experience = 0;
        this.random = new Random();
    }

    //constructyor vacío

    // Constructor para enemigos con nivel específico
    public Hero(String name, int level, int maxHealth, int attack, int defense) {
        this(name, maxHealth, attack, defense);
        this.level = level;
    }

    // Métodos
    public void drinkPotion() {
        heal(PotionHealAmount);
        System.out.println(this.name + " bebe una poción y recupera " + PotionHealAmount + " PS.");
    }

    public void rest() {
        heal(RestHealAmount);
        System.out.println(this.name + " descansa y recupera " + RestHealAmount + " PS.");
    }

    private void heal(int amount) {
        this.health += amount;
        if (this.health > this.maxHealth) {
            this.health = this.maxHealth;
        }
    }

    public void attack(Hero enemy) {
        // Cálculo del daño máximo posible: Max(Ataque - DefensaEnemigo, 10)
        int damagePotential = Math.max(this.attack - enemy.getDefense(), MinDamageCalc);
        
        // Daño real: Entre 1 y damagePotential
        int damageDealt = random.nextInt(damagePotential) + 1;
        // nextInt(N) devuelve 0..N-1. 
        // Queremos 1..N. -> nextInt(N) + 1.
        
        System.out.println(this.name + " ataca a " + enemy.getName() + " y causa " + damageDealt + " de daño.");
        enemy.receiveDamage(damageDealt);

        // Ganar experiencia
        this.experience += XpPerAttack;
        if (this.experience >= XpThresholdLevelUp) {
            levelUp();
        }
    }

    public void receiveDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    private void levelUp() {
        this.level++;
        this.maxHealth += LevelUpHealthBonus;
        this.health += LevelUpHealthBonus; // Asumimos que al subir la vida máxima, también cura esa cantidad
        this.attack += LevelUpStatBonus;
        this.defense += LevelUpStatBonus;
        this.experience -= XpThresholdLevelUp; // Reseteamos experiencia (o restamos 50)
        System.out.println("¡" + this.name + " ha subido al nivel " + this.level + "!");
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    // Getters y Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Heroe: " + name + " | Lvl: " + level + " | HP: " + health + "/" + maxHealth + 
               " | Atk: " + attack + " | Def: " + defense + " | XP: " + experience;
    }
}
