package P11ExerciseSOLID.Logger.layouts;

import P11ExerciseSOLID.Logger.loggers.MessageLogger;

public interface Layout {
    String format(String timestamp, MessageLogger.LogLevel logLevel, String message);
}
