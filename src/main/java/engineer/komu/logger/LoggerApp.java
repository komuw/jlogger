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
import java.util.Map;

class MyHash<K, V> extends HashMap<K, V> {
    @Override
    public final String toString() {
        return super.toString().replace("=", ":");
    }
}

public class LoggerApp {
    private static MyHash bound = new MyHash();

    public static void bind(MyHash b) {
        bound.putAll(b);
    }

    public static void main(String[] args) {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.FINEST);

        SimpleFormatter myFormatter = new SimpleFormatter();
        handler.setFormatter(myFormatter);

        MyHash persist = new MyHash();
        persist.put("environment", "canary");
        persist.put("customer", 12345244);
        bind(persist);

        String output = String.format("%s", persist);
        LogRecord yo = new LogRecord(Level.FINE, output);
        handler.publish(yo);
    }
}