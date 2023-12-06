import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class World {
    public int width = 800;
    public int height = 800;
    private int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    public int gasAmount = 0;
    public HashMap<Vehicle, String> vehicles = new HashMap<>();

    List<MovementObserver> movementObservers = new ArrayList<>();
    public World() {

    }

    public void addCarToWorld(Vehicle vehicle, String image, int x, int y){
        vehicles.put(vehicle, image);
        vehicle.setY(y);
        vehicle.setX(x);
    }

    public Timer getTimer(){
        return timer;
    }

    private void bounceDirection(Vehicle vehicle){
        vehicle.turnRight();
        vehicle.turnRight();
    }


    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles.keySet()) {
                if(vehicle.getX() <= 0 || vehicle.getX() >= 700) { //800 bredd - bilens bredd
                    bounceDirection(vehicle);
                }
                System.out.println(vehicle.getCurrentSpeed());
                vehicle.move();
                notifyMovementObservers();
            }
        }
    }

    public void addMovementObservers(MovementObserver movementObserver){
        movementObservers.add(movementObserver);
    }

    public void notifyMovementObservers(){
        for (MovementObserver movementObserver : movementObservers) {
            movementObserver.actOnMovementChange();
        }
    }
}
