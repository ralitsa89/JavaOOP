package P13ExerciseReflectionAndAnnotation.barracksWars03.interfaces;

import P13ExerciseReflectionAndAnnotation.barracksWars04.interfaces.Unit;
import jdk.jshell.spi.ExecutionControl;

public interface Repository {

	void addUnit(Unit unit);

	String getStatistics();

	void removeUnit(String unitType) throws ExecutionControl.NotImplementedException;
}
