package P11ExerciseSOLID.Logger.appenders;

import P11ExerciseSOLID.Logger.layouts.Layout;
import P11ExerciseSOLID.Logger.loggers.MessageLogger;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String timeStamp, MessageLogger.LogLevel logLevel, String message) {
        counter++;
        System.out.println(getLayout().format(timeStamp, logLevel, message));
    }
}
