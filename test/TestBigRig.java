import com.sun.source.tree.AssertTree;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBigRig {

    private BigRig bigRig;
    private Car car;

    @Before
    public void init() {
        bigRig = new BigRig(2, 350, Color.black, "BiggestRig", 1);
        car = new Volvo240();

        bigRig.setX(1); //den har flyttats
        bigRig.raisePlatformLowerRamp();
        bigRig.loadCar(car); // se om car och bigrig får samma x
    }

    @Test
    public void testCarIsLoadedOnBigRig() {
        assertTrue(bigRig.getListOfLoadedCars().contains(car));
    }

    @Test
    public void testLoadCarOnPlatform() {
        assertTrue(bigRig.getX() == car.getX() && bigRig.getY() == car.getY());
    }

    @Test
    public void testMoveBigRigAndCar() {
        car.move();
        bigRig.move();

        assertTrue(bigRig.getX() == car.getX() && bigRig.getY() == car.getY());
    }

    @Test
    public void testUnloadingCarFromBigRig() {
        bigRig.raisePlatformLowerRamp();
        bigRig.unloadCar();

        assertFalse(bigRig.getListOfLoadedCars().contains(car));
    }

    @Test
    public void testLoadingMoreThanCapacity() {
        Car car2 = new Car(2, 300, Color.cyan, "Emma's bil");

        bigRig.loadCar(car2);

        assertTrue(bigRig.getListOfLoadedCars().contains(car2));
    }
}
