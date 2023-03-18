package P11ExerciseSOLID.Logger.layouts;

import P11ExerciseSOLID.Logger.loggers.MessageLogger;

public class XmlLayout implements Layout {
    @Override
    public String format(String timestamp, MessageLogger.LogLevel logLevel, String message) {
        return String.format(
                "<log>%n" +
                "   <date>%s</date>%n" +
                "   <level>%s</level>%n" +
                "   <message>%s</message>%n" +
                "</log>%n", timestamp, logLevel, message);
    }
}
