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

import java.util.HashMap;

public class LoggerApp {
    private static HashMap bound = new HashMap();

    public static void bind(HashMap b) {
        bound.putAll(b);
    }

    public static void main(String[] args) {

        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);

        SimpleFormatter myFormatter = new SimpleFormatter();
        handler.setFormatter(myFormatter);

        LogRecord myRecord = new LogRecord(Level.FINEST, "hello world");
        handler.publish(myRecord);

        HashMap persist = new HashMap();
        persist.put("environment", "canary");
        persist.put("customer", 12345244);
        bind(persist);

        System.out.println("bound: " + bound);

        String output = String.format("%s", persist);
        LogRecord yo = new LogRecord(Level.FINE, output);
        handler.publish(yo);
    }
}