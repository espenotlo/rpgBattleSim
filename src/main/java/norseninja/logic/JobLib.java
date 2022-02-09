package norseninja.logic;

public class JobLib {
    public static String DEFENDER = "Defender";
    public static String SKIRMISHER = "Skirmisher";
    public static String BERSERKER = "Berserker";

    public static Job getJob(String name) {
        if (DEFENDER.equals(name)) {
            return new Job(DEFENDER, 1, 0.7, 1.5, 1.1, 1.5, 0.8, new int[]{2,8});
        } else if (SKIRMISHER.equals(name)) {
            return new Job(SKIRMISHER, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, new int[]{2,10});
        } else if (BERSERKER.equals(name)) {
            return new Job(BERSERKER, 1.2, 1.5, 0.8, 1.1, 0.8, 1.2, new int[]{2,12});
        }
        return null;
    }
}
