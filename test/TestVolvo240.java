import org.junit.Before;
import org.junit.Test;
import java.awt.*;
import static org.junit.Assert.assertTrue;

public class TestVolvo240 {

    private Volvo240 volvo240;

    @Before
    public void init() {
        volvo240 = new Volvo240();
        volvo240.startEngine();
        volvo240.move();
    }

    @Test
    public void testIsEngineON() {
        assertTrue(volvo240.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testIsEngineOFF() {
        volvo240.stopEngine();
        assertTrue(volvo240.getCurrentSpeed() == 0);
    }

    @Test
    public void testGetColor() {
        assertTrue(volvo240.getColor() == Color.black);
    }

    @Test
    public void testSetColor() {
        volvo240.setColor(Color.cyan);
        assertTrue(volvo240.getColor() == Color.cyan);
    }

    @Test
    public void testGetNrDoors() {
        assertTrue(volvo240.getNrDoors() == 4);
    }

    @Test
    public void testGetEnginePower() {
        assertTrue(volvo240.getEnginePower() == 100);
    }

    @Test
    public void testSpeedFactor(){
        double speedFactorValue = 100 * 0.01 * 1.25;
        assertTrue(volvo240.speedFactor() == speedFactorValue);
    }


    @Test
    public void testMove(){
        assertTrue(volvo240.getX() == 0 && volvo240.getY() == 0.1);
    }

    @Test
    public void testTurnRight(){
        volvo240.turnRight();
        assertTrue(volvo240.getDirection() == Direction.EAST);
    }

    @Test
    public void testTurnRight360(){
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.turnRight();
        volvo240.turnRight();

        assertTrue(volvo240.getDirection() == Direction.NORTH);
    }
    @Test
    public void testTurnLeft(){
        volvo240.turnLeft();
        assertTrue(volvo240.getDirection() == Direction.WEST);
    }

    @Test
    public void testTurnLeft360(){
        volvo240.turnLeft();
        volvo240.turnLeft();
        volvo240.turnLeft();
        volvo240.turnLeft();

        assertTrue(volvo240.getDirection() == Direction.NORTH);
    }
}
