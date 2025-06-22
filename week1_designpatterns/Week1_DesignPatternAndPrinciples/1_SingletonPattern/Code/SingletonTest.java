/**
 * Test class to verify Singleton Pattern implementation
 * Demonstrates that only one instance of Logger is created and used
 */
public class SingletonTest {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern Test ===\n");
        
        // Test 1: Get first instance
        System.out.println("Test 1: Getting first Logger instance...");
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message from logger1");
        logger1.logInfo("Info message from logger1");
        
        // Test 2: Get second instance (should be the same as first)
        System.out.println("\nTest 2: Getting second Logger instance...");
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message from logger2");
        logger2.logError("Error message from logger2");
        
        // Test 3: Verify both instances are the same
        System.out.println("\nTest 3: Verifying both instances are the same...");
        if (logger1 == logger2) {
            System.out.println("✓ SUCCESS: Both logger instances are the same object!");
            System.out.println("✓ Singleton pattern is working correctly!");
        } else {
            System.out.println("✗ FAILED: Logger instances are different objects!");
        }
        
        // Test 4: Hash code comparison
        System.out.println("\nTest 4: Hash code comparison...");
        System.out.println("Logger1 hash code: " + logger1.hashCode());
        System.out.println("Logger2 hash code: " + logger2.hashCode());
        
        if (logger1.hashCode() == logger2.hashCode()) {
            System.out.println("✓ Hash codes match - confirming same instance!");
        } else {
            System.out.println("✗ Hash codes don't match!");
        }
        
        // Test 5: Multiple calls to getInstance
        System.out.println("\nTest 5: Multiple getInstance() calls...");
        for (int i = 1; i <= 3; i++) {
            Logger tempLogger = Logger.getInstance();
            tempLogger.log("Log message #" + i + " from temporary logger");
        }
        
        System.out.println("\n=== Singleton Pattern Test Complete ===");
        System.out.println("Note: You should see 'Logger instance created!' only once at the beginning.");
    }
} 