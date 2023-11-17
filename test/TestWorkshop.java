import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestWorkshop {

    private Workshop<Car> carWorkshop = new Workshop<>();
    private Workshop<Saab95> saabWorkshop = new Workshop<>();
    Car saab95 = new Saab95();
    Truck scania = new Scania();


    @Before
    public void init(){
        carWorkshop.load(saab95);
    }

    @Test
    public void testIfCarInListOfLoadedCars(){
        assertTrue(carWorkshop.getListOfLoadedCars().contains(saab95));
    }

    @Test
    public void testIfCarNotInListOfLoadedCars(){
        carWorkshop.unload(saab95);
        assertFalse(carWorkshop.getListOfLoadedCars().contains(saab95));

    }
}
