package norseninja.logic;

import java.util.Random;

public class DiceRoller {
    public static int roll(Random r, int numberOfDice, int diceSize) {
        int total = 0;
        for (int i = 0; i<numberOfDice; i++) {
            total+= r.nextInt(diceSize) + 1;
        }
        return total;
    }
}
