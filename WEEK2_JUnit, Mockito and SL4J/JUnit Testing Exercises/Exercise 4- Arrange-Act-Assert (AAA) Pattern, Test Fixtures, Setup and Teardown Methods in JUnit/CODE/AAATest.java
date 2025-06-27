import org.junit.*;
import static org.junit.Assert.*;

public class AAATest {
    private int value;

    @Before
    public void setUp() {
        // Arrange: Initialize resources
        value = 10;
    }

    @Test
    public void testAddition() {
        // Act
        int result = value + 5;
        // Assert
        assertEquals(15, result);
    }

    @Test
    public void testSubtraction() {
        // Act
        int result = value - 3;
        // Assert
        assertEquals(7, result);
    }

    @After
    public void tearDown() {
        // Cleanup resources
        value = 0;
    }
} 