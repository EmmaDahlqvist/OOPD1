
public class Main {
    public static void main(String[] args) {
        World world = new World();
        DrawPanel drawPanel = new DrawPanel(world.width, world.height-240, world.vehicles);
        CarView carView = new CarView("CarSim 2.0", drawPanel, world);
        CarController cc = new CarController(world, carView);

        world.addCarToWorld(new Volvo240(),0, 0);
        world.addCarToWorld(new Scania(), 0, 100);
        world.addCarToWorld(new Saab95(), 0, 200);

        //lägg till observer som notifieras vid rörelseändringar
        world.addMovementObservers(drawPanel);

        world.getTimer().start();
    }

}
