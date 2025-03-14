package Creational.Singleton;


public class DIY {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is the first log message.");

        Logger anotherLogger = Logger.getInstance();
        anotherLogger.log("This is the second log message.");

        // Both logger and anotherLogger should be the same instance
        System.out.println("Are both loggers the same instance? " + (logger == anotherLogger? "correct" : "wrong"));
    }
}

class Logger {
    
    private static volatile Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

  
    public void log(String message){
        System.out.println("Log: " + message);
    }
}