package P13ExerciseReflectionAndAnnotation.barracksWars03;

import P13ExerciseReflectionAndAnnotation.barracksWars04.core.Engine;
import P13ExerciseReflectionAndAnnotation.barracksWars04.core.factories.UnitFactoryImpl;
import P13ExerciseReflectionAndAnnotation.barracksWars04.data.UnitRepository;
import P13ExerciseReflectionAndAnnotation.barracksWars04.interfaces.Repository;
import P13ExerciseReflectionAndAnnotation.barracksWars04.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
