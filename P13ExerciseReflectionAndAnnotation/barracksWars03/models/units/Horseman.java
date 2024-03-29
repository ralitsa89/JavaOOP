package P13ExerciseReflectionAndAnnotation.barracksWars03.models.units;

import P13ExerciseReflectionAndAnnotation.barracksWars04.models.units.AbstractUnit;

public class Horseman extends AbstractUnit {
    private static final int HORSEMAN_HEALTH = 50;
    private static final int HORSEMAN_DAMAGE = 10;

    public Horseman() {
        super(HORSEMAN_HEALTH, HORSEMAN_DAMAGE);
    }
}
