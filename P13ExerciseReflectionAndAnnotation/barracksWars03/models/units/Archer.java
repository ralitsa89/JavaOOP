package P13ExerciseReflectionAndAnnotation.barracksWars03.models.units;

import P13ExerciseReflectionAndAnnotation.barracksWars04.models.units.AbstractUnit;

public class Archer extends AbstractUnit {
    private static final int ARCHER_HEALTH = 25;
    private static final int ARCHER_DAMAGE = 7;

    public Archer() {
        super(ARCHER_HEALTH, ARCHER_DAMAGE);
    }
}
