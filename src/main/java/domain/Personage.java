package domain;

public class Personage implements WithStats {

    private String name;
    private int healthPoints;
    private Stats statsBase; // RENOMBRADO
    private StatsModifier modifiers;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int healthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        if(healthPoints < 0) {
            healthPoints = 0;
        }
        this.healthPoints = healthPoints;
    }

    public Stats statsBase() { // RENOMBRADO
        return statsBase;
    }

    public void setStatsBase(Stats statsBase) { // RENOMBRADO
        this.statsBase = statsBase;
    }

    public StatsModifier modifiers() { // NUEVO!
        return modifiers;
    }

    public void setModifiers(StatsModifier modifiers) {
        this.modifiers = modifiers;
    }

    @Override
    public int vitality() { // NUEVO!
        return statsBase.vitality() + modifiers.vitality();
    }

    @Override
    public int strength() { // NUEVO!
        return statsBase.strength() + modifiers.strength();
    }

    @Override
    public int intelligence() { // NUEVO!
        return statsBase.intelligence() + modifiers.intelligence();
    }
}
