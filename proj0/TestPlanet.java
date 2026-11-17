import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlanet {
    /**
     *  Checks the Planet class to make sure calcForceExertedByXY works.
     */
    @Test 
    public void testCalcForceExertedByXY() {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(2.0, 1.0, 3.0, 4.0, 4e11, "jupiter.gif");
        Planet p3 = new Planet(4.0, 5.0, 3.0, 4.0, 5.0, "jupiter.gif");

        assertEquals(p1.calcForceExertedByX(p2), 133.4, 0.01);
        assertEquals(p1.calcForceExertedByX(p3), 4.002e-11, 0.01);
        assertEquals(p1.calcForceExertedByY(p2), 0.0, 0.01);
        assertEquals(p1.calcForceExertedByY(p3), 5.336e-11, 0.01);
    }
}
