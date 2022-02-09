package norseninja.logic;

public class Main {
    public static void main(String[] args) {
        FightSimulator sim = new FightSimulator();
        sim.presentFighters();

        int difference = 0;
        for (int i = 0; i<10000; i++) {
            sim = new FightSimulator();
            difference += sim.fight();
        }

        System.out.println();
        //Positive difference: first fighter leads.
        System.out.println("Difference: " + difference);
    }
}
