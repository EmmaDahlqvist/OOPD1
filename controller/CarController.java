package controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.*;
import view.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    private World world;

    private CarView carView;

    public CarController(World world, CarView carView){
        this.world = world;
        this.carView = carView;

        initButtonFunctions();
    }

    private void initButtonFunctions(){
        carView.addActionListenerToGasButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(world.gasAmount);
            }
        });

        carView.addActionListenerToBrakeButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(world.gasAmount);
            }
        });

        carView.addActionListenerToTurboOnButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });

        carView.addActionListenerToTurboOffButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });

        carView.addActionListenerToLiftBedButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });

        carView.addActionListenerToLowerBedButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        carView.addActionListenerToStartButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startVehicle();
            }
        });

        carView.addActionListenerToStopButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopVehicle();
            }
        });

        carView.addChangeListenerToGasSpinner(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                world.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });

        carView.addActionListenerToAddCarButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                world.addCarToWorld();
            }
        });

        carView.addActionListenerToRemoveCarButton(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){ world.removeCarFromWorld(); }
        });
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : world.vehicles) {
            car.gas(gas);
        }
    }

    protected void brake(int amount ){
        double brake = ((double ) amount ) / 100;
        for(Vehicle car:world.vehicles) {
            car.brake(brake);
        }
    }

    protected void setTurboOn(){
        for(Vehicle car: world.vehicles) {
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    protected void setTurboOff(){
        for(Vehicle car: world.vehicles) {
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    protected void liftBed(){
        for(Vehicle car: world.vehicles) {
            if(car instanceof Scania){
                ((Scania) car).raisePlatformDegree(70);
            }
        }
    }

    protected void lowerBed(){
        for(Vehicle car: world.vehicles) {
            if(car instanceof Scania){
                ((Scania) car).lowerPlatformDegree(70);
            }
        }
    }

    protected void startVehicle() {
        for (Vehicle car: world.vehicles) {
            car.startEngine();
        }
    }

    protected void stopVehicle() {
        for (Vehicle car: world.vehicles) {
            car.stopEngine();
        }
    }

}
