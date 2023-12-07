/*
import model.BigRig;
import model.Car;
import model.Saab95;
import model.Volvo240;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestBigRig {

    private BigRig bigRig;
    private Car car;
    private Car car2;

    @Before
    public void init() {
        bigRig = new BigRig(1);
        car = new Volvo240();
        car2 = new Saab95();

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
        bigRig.loadCar(car2);
        bigRig.unloadCar();

        assertTrue(bigRig.getListOfLoadedCars().contains(car) && !bigRig.getListOfLoadedCars().contains(car2));
    }

    @Test
    public void testLoadingMoreThanCapacity() {

        bigRig.loadCar(car2);

        assertTrue(bigRig.getListOfLoadedCars().contains(car2));
    }
}
*/
