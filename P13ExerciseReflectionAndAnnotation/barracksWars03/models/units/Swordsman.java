package P13ExerciseReflectionAndAnnotation.barracksWars03.models.units;

import P13ExerciseReflectionAndAnnotation.barracksWars04.models.units.AbstractUnit;

public class Swordsman extends AbstractUnit {
    private static final int SWORDSMAN_HEALTH = 40;
    private static final int SWORDSMAN_DAMAGE = 13;

    public Swordsman() {
        super(SWORDSMAN_HEALTH, SWORDSMAN_DAMAGE);
    }
}
