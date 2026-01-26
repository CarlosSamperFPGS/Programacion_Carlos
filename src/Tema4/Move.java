package Tema4;

public class Move {
    private String name;
    private String type;
    private String category; // "Fisico", "Especial", "Estado"
    private int power;
    private int accuracy;
    private int pp;
    private int maxPp;
    private String effect; // "PAR", "BRN", "PSN", "SLP", "FRZ", "HEAL", "PROTECT", "NONE"
    private double effectChance;

    public Move(String name, String type, String category, int power, int accuracy, int pp, String effect, double effectChance) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.maxPp = pp;
        this.effect = effect;
        this.effectChance = effectChance;
    }

    // Constructor simplificado para compatibilidad o movimientos simples
    public Move(String name, String type, String category, int power) {
        this(name, type, category, power, 100, 15, "NONE", 0.0);
    }

    public String getName() { return name; }
    public String getType() { return type; }
    public String getCategory() { return category; }
    public int getPower() { return power; }
    public int getAccuracy() { return accuracy; }
    public int getPp() { return pp; }
    public int getMaxPp() { return maxPp; }
    public String getEffect() { return effect; }
    public double getEffectChance() { return effectChance; }

    public void decrementPp() {
        if (this.pp > 0) this.pp--;
    }
    
    public void restorePp() {
        this.pp = this.maxPp;
    }
}
