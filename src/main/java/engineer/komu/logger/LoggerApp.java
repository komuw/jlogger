/*-
run this as:
  export CLASSPATH=/Users/komuw/mystuff/jlogger/src/main/java && \
  javac engineer/komu/logger/LoggerApp.java && \
  java engineer/komu/logger/LoggerApp
  
  or
  java engineer.komu.logger.LoggerApp

*/
package engineer.komu.logger;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.ConsoleHandler;
import java.util.logging.SimpleFormatter;

public class LoggerApp {
    public static void main(String[] args) {

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);

        SimpleFormatter myFormatter = new SimpleFormatter();
        handler.setFormatter(myFormatter);

        LogRecord myRecord = new LogRecord(Level.FINEST, "hello world");// LogRecord(Level level, String msg)
        handler.publish(myRecord);

    }
}