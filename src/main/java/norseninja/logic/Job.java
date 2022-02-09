package norseninja.logic;

public class Job {
    private final String name;
    private final double accuracyModifier;
    private final double damageModifier;
    private final double damageResistance;
    private final double dodgeChanceModifier;
    private final double blockChanceModifier;
    private final double initiativeModifier;
    private final int[] damage;

    public Job(String name, double accuracyModifier, double damageModifier, double damageResistance, double dodgeChanceModifier, double blockChanceModifier, double initiativeModifier, int[] damage) {
        this.name = name;
        this.accuracyModifier = accuracyModifier;
        this.damageModifier = damageModifier;
        this.damageResistance = damageResistance;
        this.dodgeChanceModifier = dodgeChanceModifier;
        this.blockChanceModifier = blockChanceModifier;
        this.initiativeModifier = initiativeModifier;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public double getAccuracyModifier() {
        return accuracyModifier;
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public double getDamageResistance() {
        return damageResistance;
    }

    public double getDodgeChanceModifier() {
        return dodgeChanceModifier;
    }

    public double getBlockChanceModifier() {
        return blockChanceModifier;
    }

    public double getInitiativeModifier() {
        return initiativeModifier;
    }

    public int[] getDamage() {
        return damage;
    }
}
