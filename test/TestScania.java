import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestScania {
    private Scania scania;

    @Before
    public void init(){
        scania = new Scania();
    }


    @Test
    public void testRaisePlatform() {
        int degree = scania.getPlatformDegree();
        scania.raisePlatformDegree(5);

        assertTrue(scania.getPlatformDegree() > degree);
    }
    @Test
    public void testLowerPlatform() {
        scania.raisePlatformDegree(10);
        int degree = scania.getPlatformDegree();
        scania.lowerPlatformDegree(5);

        assertTrue(scania.getPlatformDegree() < degree);
    }

    @Test
    public void testmoveWithRaisedPlatform(){
        scania.raisePlatformDegree(40);
        double y = scania.getY();
        scania.move();
        assertTrue(scania.getY() == y);
    }

}
