package P11ExerciseSOLID.Logger.layouts;

import P11ExerciseSOLID.Logger.loggers.MessageLogger;

public class ComplexLayout implements Layout {
    @Override
    public String format(String timestamp, MessageLogger.LogLevel logLevel, String message) {
        return String.format("%s PM <-> %s <-> %s.", timestamp, logLevel, message);
    }
}
