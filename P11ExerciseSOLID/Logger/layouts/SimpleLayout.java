package P11ExerciseSOLID.Logger.layouts;

import P11ExerciseSOLID.Logger.loggers.MessageLogger;

public class SimpleLayout implements  Layout {

    @Override
    public String format(String timeStamp, MessageLogger.LogLevel logLevel, String message){
        return String.format("%s – %s – %s", timeStamp, logLevel, message);
    }
}
