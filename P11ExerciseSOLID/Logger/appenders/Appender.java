package P11ExerciseSOLID.Logger.appenders;

import P11ExerciseSOLID.Logger.layouts.Layout;
import P11ExerciseSOLID.Logger.loggers.MessageLogger;

public interface Appender {
    void append(String timeStamp, MessageLogger.LogLevel logLevel, String message);
    Layout getLayout();
    int getMessagesCount();
}
