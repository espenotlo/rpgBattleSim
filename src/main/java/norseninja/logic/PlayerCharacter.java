package norseninja.logic;

import java.util.HashMap;
import java.util.Map;

public class PlayerCharacter extends Unit {
    private String job;

    public PlayerCharacter(String name, Job job) {
        super(name);
        setJob(job);
    }

    public Job getJob() {
        return JobLib.getJob(job);
    }

    public void setJob(Job job) {
        this.job = job.getName();
        super.setAccuracy(job.getAccuracyModifier());
        super.setDamageModifier(job.getDamageModifier());
        super.setDamageResistance(job.getDamageResistance());
        super.setDodgeChanceModifier(job.getDodgeChanceModifier());
        super.setBlockChanceModifier(job.getBlockChanceModifier());
        super.setInitiativeModifier(job.getInitiativeModifier());
    }

    @Override
    public Map<String, Object> getInfo() {
        Map<String, Object> info = super.getInfo();
        info.put("job", job);

        return info;
    }
}
