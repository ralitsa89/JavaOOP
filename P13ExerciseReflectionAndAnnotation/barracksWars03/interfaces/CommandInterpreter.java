package P13ExerciseReflectionAndAnnotation.barracksWars03.interfaces;

import P13ExerciseReflectionAndAnnotation.barracksWars04.interfaces.Executable;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
