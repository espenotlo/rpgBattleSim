package norseninja.logic;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Unit {
    private String name;
    private int hp;
    private double damageModifier;
    private double accuracy;
    private double dodgeChanceModifier;
    private double blockChanceModifier;
    private double damageResistance;
    private double initiativeModifier;
    private int[] damage;
    private final Random r;


    protected Unit(String name) {
        this.name = name;
        this.hp = 50;
        this.damageModifier = 1;
        this.accuracy = 1;
        this.dodgeChanceModifier = 1;
        this.blockChanceModifier = 1;
        this.damageResistance = 1;
        this.initiativeModifier = 1;
        this.damage = new int[]{2, 6};
        this.r = new Random(LocalTime.now().getNano());
    }

    public boolean attack() {

        //base chance to hit = 80%, modified by attackers accuracy, up to 100% at accuracy modifier 2,
        //and target's block & dodge chances.
        if (r.nextInt(100) > 20-20*(accuracy-1)) {
            return true;
        }
        return false;
    }

    //base damage = 20, modified by attackers damage modifier, and targets damage resistance modifier.
    public int damage(Unit target) {
        return (int) Math.floor(20*damageModifier*(2-target.getDamageResistance()));
    }

    //base dodge = 10%, modified by dodge chance modifier, up to max dodge chance of 50% at modifier 2.
    public boolean dodge() {
        return r.nextInt(100) < 10+40*(dodgeChanceModifier-1);
    }

    //base block = 10%, modified by block chance modifier, up to max block chance of 50% at modifier 2.
    public boolean block() {
        return r.nextInt(100) < 10+40*(blockChanceModifier-1);
    }

    public int rollInitiative() {
        return (int) Math.floor(r.nextInt(100)*initiativeModifier);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }

    public double getDamageModifier() {
        return damageModifier;
    }

    public void setDamageModifier(double damageModifier) {
        this.damageModifier = damageModifier;
    }

    public double getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(double accuracy) {
        this.accuracy = accuracy;
    }

    public double getDodgeChanceModifier() {
        return dodgeChanceModifier;
    }

    public void setDodgeChanceModifier(double dodgeChanceModifier) {
        this.dodgeChanceModifier = dodgeChanceModifier;
    }

    public double getBlockChanceModifier() {
        return blockChanceModifier;
    }

    public void setBlockChanceModifier(double blockChanceModifier) {
        this.blockChanceModifier = blockChanceModifier;
    }

    public double getDamageResistance() {
        return damageResistance;
    }

    public void setDamageResistance(double damageResistance) {
        this.damageResistance = damageResistance;
    }

    public double getInitiativeModifier() {
        return initiativeModifier;
    }

    public void setInitiativeModifier(double initiativeModifier) {
        this.initiativeModifier = initiativeModifier;
    }

    public int[] getDamage() {
        return this.damage;
    }

    public void setDamage(int[] damage) {
        this.damage = damage;
    }

    public Map<String, Object> getInfo() {
        HashMap<String, Object> info = new HashMap<>();
        info.put("name", name);
        info.put("hp", hp);
        info.put("damageModifier", damageModifier);
        info.put("accuracy", accuracy);
        info.put("dodgeChanceModifier", dodgeChanceModifier);
        info.put("blockChanceModifier", blockChanceModifier);
        info.put("damageResistance", damageResistance);
        info.put("initiativeModifier", initiativeModifier);

        return info;
    }
}
