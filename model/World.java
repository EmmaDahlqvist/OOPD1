package model;

import model.MovementObserver;
import model.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class World {
    public int width = 800;
    public int height = 800;
    private int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    public int gasAmount = 0;
    public List<Vehicle> vehicles = new ArrayList<>();

    List<MovementObserver> movementObservers = new ArrayList<>();
    public World() {

    }

    public void addCar(Vehicle vehicle, int x, int y){
        vehicles.add(vehicle);
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
            for (Vehicle vehicle : vehicles) {
                if(vehicle.getX() <= 0 || vehicle.getX() >= 700) { //800 bredd - bilens bredd
                    bounceDirection(vehicle);
                }
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
