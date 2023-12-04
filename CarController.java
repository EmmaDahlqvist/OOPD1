import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    protected HashMap<Vehicle, String> cars = new HashMap<>();

    //methods:
    public Timer getTimer() {
        return timer;
    }


    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars.keySet()) {
                if(car.getX() <= 0 || car.getX() >= 700) { //800 bredd - bilens bredd
                    bounceDirection(car);
                }

                car.move();


//                car.move();
//                int x = (int) Math.round(car.getX());
//                int y = (int) Math.round(car.getY());
//                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }


    public void initCarPositions(HashMap<Vehicle, String> cars){
        int y = 0;
        for(Vehicle car : cars.keySet()){
            car.setY(y);
            y += 100;
        }
    }

    private void bounceDirection(Vehicle car){
        car.turnRight();
        car.turnRight();
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars.keySet()) {
            car.gas(gas);
        }
    }

    protected void brake(int amount ){
        double brake = ((double ) amount ) / 100;
        for(Vehicle car: cars.keySet()) {
            car.brake(brake);
        }
    }

    protected void setTurboOn(){
        for(Vehicle car: cars.keySet()) {
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    protected void setTurboOff(){
        for(Vehicle car: cars.keySet()) {
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    protected void liftBed(){
        for(Vehicle car: cars.keySet()) {
            if(car instanceof Scania){
                ((Scania) car).raisePlatformDegree(70);
            }
        }

    }

    protected void lowerBed(){
        for(Vehicle car: cars.keySet()) {
            if(car instanceof Scania){
                ((Scania) car).lowerPlatformDegree(70);
            }
        }
    }

    protected void startVehicle() {
        for (Vehicle car: cars.keySet()) {
            car.startEngine();
        }
    }

    protected void stopVehicle() {
        for (Vehicle car: cars.keySet()) {
            car.stopEngine();
        }
    }

}
