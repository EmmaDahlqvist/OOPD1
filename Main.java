import controller.CarController;
import model.*;
import view.*;

public class Main {
    public static void main(String[] args) {
        World world = new World();
        DrawPanel drawPanel = new DrawPanel(world.width, world.height-240, world.vehicles);
        CarView carView = new CarView("CarSim 2.0", drawPanel, world);
        CarController cc = new CarController(world, carView);

        world.addCarToWorld(VehicleFactory.createVolvo240(),0, 0);
        world.addCarToWorld(VehicleFactory.createScania(), 0, 100);
        world.addCarToWorld(VehicleFactory.createSaab95(), 0, 200);

        //lägg till observer som notifieras vid rörelseändringar
        world.addMovementObservers(drawPanel);

        world.getTimer().start();
    }

}
