package P13ExerciseReflectionAndAnnotation.barracksWars04.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
