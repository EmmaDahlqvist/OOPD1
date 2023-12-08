import controller.CarController;
import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        CarView carView = new CarView("CarSim 2.0", world);
        CarController cc = new CarController(world, carView);

        world.addCar(VehicleFactory.createVolvo240(),0, 0);
        world.addCar(VehicleFactory.createScania(), 0, 70);
        world.addCar(VehicleFactory.createSaab95(), 0, 140);

        world.getTimer().start();
    }

}
