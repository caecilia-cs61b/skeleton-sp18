import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    public boolean isSameNumber(Integer a, Integer b) {
        return a == b;
    }

    @Test
    public void testIntegerCacheA() {
        assertTrue(isSameNumber(-128, -128));
    }

    @Test
    public void testIntegerCacheB() {
        assertTrue(isSameNumber(0, 0));
    }
    
    @Test
    public void testIntegerCacheC() {
        assertTrue(isSameNumber(127, 127));
    }
    
    @Test
    public void testIntegerCacheD() {
        assertTrue(isSameNumber(128, 128));
    }

    public static void main(String... args) {        
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }
}
