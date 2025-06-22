/**
 * Logger class implementing Singleton Pattern
 * Ensures only one instance of Logger exists throughout the application
 */
public class Logger {
    // Private static instance of the Logger class
    private static Logger instance;
    
    // Private constructor to prevent instantiation from outside
    private Logger() {
        System.out.println("Logger instance created!");
    }
    
    /**
     * Public static method to get the singleton instance
     * Creates the instance if it doesn't exist (lazy initialization)
     * @return The singleton instance of Logger
     */
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
    
    /**
     * Method to log messages
     * @param message The message to log
     */
    public void log(String message) {
        System.out.println("[LOG] " + message);
    }
    
    /**
     * Method to log error messages
     * @param error The error message to log
     */
    public void logError(String error) {
        System.out.println("[ERROR] " + error);
    }
    
    /**
     * Method to log info messages
     * @param info The info message to log
     */
    public void logInfo(String info) {
        System.out.println("[INFO] " + info);
    }
} 