
public class Main {
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.put(new Volvo240(), "pics/Volvo240.jpg");
        cc.cars.put(new Scania(), "pics/Scania.jpg");
        cc.cars.put(new Saab95(), "pics/Saab95.jpg");
        cc.cars.put(new Saab95(), "pics/Saab95.jpg");

        cc.initCarPositions(cc.cars);

//        Veichle saab = new Saab95();
//        saab.setY(100);
//
//        Veichle volvo = new Volvo240();
//
//        Veichle scania = new Scania();
//        scania.setY(200);
//
//        cc.cars.put(scania,"pics/Scania.jpg");
//        cc.cars.put(saab, "pics/Saab95.jpg");


        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.getTimer().start();
    }

}
