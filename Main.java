import controller.CarController;
import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        DrawPanel drawPanel = new DrawPanel(world.width, world.height-240, world.vehicles);
        CarView carView = new CarView("CarSim 2.0", drawPanel, world);
        CarController cc = new CarController(world, carView);

        world.addCar(VehicleFactory.createVolvo240(),0, 0);
        world.addCar(VehicleFactory.createScania(), 0, 70);
        world.addCar(VehicleFactory.createSaab95(), 0, 140);

        world.getTimer().start();
    }

}
