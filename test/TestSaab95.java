import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestSaab95 {
    private Saab95 saab95;

    @Before
    public void init(){
        saab95 = new Saab95();
        saab95.startEngine();
    }

    @Test
    public void testTurboOn(){
        saab95.setTurboOn();
        assertTrue(saab95.turboOn);
    }
    @Test
    public void testTurboOff(){
        saab95.setTurboOff();
        assertFalse(saab95.turboOn);
    }

    @Test
    public void testSpeedFactorTurboOff(){
        double speedFactor = 1*0.01*125;
        assertTrue(saab95.speedFactor() == speedFactor);
    }

    @Test
    public void testSpeedFactorTurboOn(){
        saab95.setTurboOn();
        double speedFactor = 125 * 0.01 * 1.3;
        assertEquals(speedFactor, saab95.speedFactor());
    }


    @Test
    public void testGasAmountOutsideRange(){
        double speed = saab95.getCurrentSpeed();
        saab95.gas(2);
        assertTrue(speed == saab95.getCurrentSpeed());
    }

    @Test
    public void testBreakAmountOutsideRange(){
        double speed = saab95.getCurrentSpeed();
        saab95.brake(2);
        assertTrue(speed == saab95.getCurrentSpeed());
    }

    @Test
    public void testGasLargerThanEnginePower(){
        System.out.println(saab95.getCurrentSpeed());
        for (int i = 0; i < 120; i++) {
            saab95.gas(1);
        }
        System.out.println(saab95.getCurrentSpeed());

        assertFalse(saab95.getCurrentSpeed() > saab95.getEnginePower());
    }

    @Test
    public void testBrakeLessThan0(){
        System.out.println(saab95.getCurrentSpeed());
        for (int i = 0; i < 20; i++) {
            saab95.brake(1);
        }
        System.out.println(saab95.getCurrentSpeed());

        assertFalse(saab95.getCurrentSpeed() < 0);

    }



}
