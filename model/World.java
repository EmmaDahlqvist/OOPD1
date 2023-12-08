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
    public int height = 1000;
    private int delay = 50;
    private Timer timer = new Timer(delay, new TimerListener());
    public int gasAmount = 0;
    public List<Vehicle> vehicles = new ArrayList<>();

    List<MovementObserver> movementObservers = new ArrayList<>();

    public void addCar(Vehicle vehicle, int x, int y){
        vehicles.add(vehicle);
        vehicle.setY(y);
        vehicle.setX(x);
    }

    public void addCarToWorld(){
        if(vehicles.size() < 10){
            int nextY = nextY();
            addCar(new Volvo240(), 0, nextY);
        }
    }

    private int nextY() {
        if(vehicles.isEmpty()){
            return 0;
        } else {
            return (int) vehicles.get(vehicles.size() - 1).getY() + 60 + 10; // 10 + sista bilens Y
        }
    }

    public void removeCarFromWorld(){
        if(!vehicles.isEmpty()) {
            vehicles.remove(vehicles.size()-1);
        }
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
                if(vehicle.getX() <= 0 || vehicle.getX() >= width-100) {
                    bounceDirection(vehicle);
                }
                vehicle.move();
            }
            notifyMovementObservers();
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
