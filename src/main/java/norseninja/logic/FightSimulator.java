package norseninja.logic;

import java.util.Map;

public class FightSimulator {
    private PlayerCharacter fighterOne;
    private PlayerCharacter fighterTwo;
    private int roundNumber = 0;

    public FightSimulator() {
        fighterOne = new PlayerCharacter("Michael Jackson", JobLib.getJob(JobLib.SKIRMISHER));
        fighterTwo = new PlayerCharacter("Elton John", JobLib.getJob(JobLib.DEFENDER));
    }

    public FightSimulator(PlayerCharacter fighterOne, PlayerCharacter fighterTwo) {
        this.fighterOne = fighterOne;
        this.fighterTwo = fighterTwo;
    }

    public void presentFighters() {
        System.out.println();
        listFighter(fighterOne);
        System.out.println();
        listFighter(fighterTwo);
    }

    private void listFighter(PlayerCharacter pc) {
        Map<String, Object> f1 = pc.getInfo();
        System.out.println("Name: " + f1.get("name"));
        System.out.println("Job: " + f1.get("job"));
        System.out.println("Hit Points: " + f1.get("hp"));
        System.out.println("Damage Modifier: " + f1.get("damageModifier"));
        System.out.println("Accuracy: " + f1.get("accuracy"));
        System.out.println("Dodge Chance Modifier: " + f1.get("dodgeChanceModifier"));
        System.out.println("Block Chance Modifier: " + f1.get("blockChanceModifier"));
        System.out.println("Damage Resistance: " + f1.get("damageResistance"));
        System.out.println("Initiative Modifier: " + f1.get("initiativeModifier"));
    }

    public int fight() {
        System.out.println();
        System.out.println("In the blue corner - " + fighterOne.getName() + ", the " + fighterOne.getJob().getName() + ".");
        System.out.println("In the red corner - " + fighterTwo.getName() + ", the " + fighterTwo.getJob().getName() + ".");
        System.out.println();

        int victor = 0;

        while (fighterOne.getHp() > 0 && fighterTwo.getHp() > 0) {
            roundNumber++;
            System.out.println("----------------- round : "+ roundNumber +" ----------------");
            Unit first = rollInitiatives();
            Unit second;
            if (first == fighterOne) {
                second = fighterTwo;
            } else {
                second = fighterOne;
            }
            System.out.println(first.getName() + " won the initiative and goes on the attack!");
            makeAttack(first, second);
            if (second.getHp() > 0) {
                System.out.println("Having survived the attack from " + first.getName() + ", " + second.getName() + " retaliates..");
                makeAttack(second, first);
                if (first.getHp() == 0) {
                    System.out.println();
                    System.out.println(first.getName() + " has been knocked out; " + second.getName() + " is the victor!");
                    victor = -1;
                }
            } else {
                //first combatant won
                System.out.println();
                System.out.println(second.getName() + " has been knocked out - " + first.getName() + " is the victor!");
                victor = 1;
            }
        }
        return victor;
    }

    private Unit rollInitiatives() {
        if (fighterOne.rollInitiative() >= fighterTwo.rollInitiative()) {
            return fighterOne;
        } else {
            return fighterTwo;
        }
    }

    private void makeAttack(Unit first, Unit second) {
        if (first.attack()) {
            if (second.dodge()) {
                System.out.println(first.getName() + " attacks, but was successfully dodged.");
            } else if (second.block()) {
                System.out.println(first.getName() + " attacks, but " + second.getName() + " blocked the hit!");
            } else {
                int damage = first.damage(second);
                second.setHp(second.getHp() - damage);
                if (second.getHp() == 0) {
                    System.out.println(second.getName() + " was hit for " + damage + " damage, and was knocked out!");
                } else {
                    System.out.println(second.getName() + " was hit for " + damage + " damage, and has " + second.getHp() + " remaining hp!");
                }
            }
        } else {
            System.out.println(first.getName() + " swung but missed..");
        }
    }
}
