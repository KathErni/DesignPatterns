class Logger {
  private static instance: Logger;

  private constructor() {}

  public static getInstance(): Logger {
    if (!Logger.instance) {
      Logger.instance = new Logger();
    }
    return Logger.instance;
  }

  public log(message: string): void {
    console.log("Log: " + message);
  }
}

// Main function
function DIYSingleton(): void {
  const logger = Logger.getInstance();
  logger.log("This is the first log message.");

  const anotherLogger = Logger.getInstance();
  anotherLogger.log("This is the second log message.");

  // Both logger and anotherLogger should be the same instance
  console.log(
    "Are both loggers the same instance? " +
      (logger === anotherLogger ? "correct" : "wrong")
  );
}

DIYSingleton();
