import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        carView.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(world.gasAmount);
            }
        });

        carView.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(world.gasAmount);
            }
        });

        carView.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOn();
            }
        });

        carView.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setTurboOff();
            }
        });

        carView.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });

        carView.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });

        carView.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startVehicle();
            }
        });

        carView.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopVehicle();
            }
        });

        carView.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                world.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
    }

    // Calls the gas method for each car once
    protected void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : world.vehicles.keySet()) {
            car.gas(gas);
        }
    }

    protected void brake(int amount ){
        double brake = ((double ) amount ) / 100;
        for(Vehicle car: world.vehicles.keySet()) {
            car.brake(brake);
        }
    }

    protected void setTurboOn(){
        for(Vehicle car: world.vehicles.keySet()) {
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOn();
            }
        }
    }

    protected void setTurboOff(){
        for(Vehicle car: world.vehicles.keySet()) {
            if(car instanceof Saab95){
                ((Saab95) car).setTurboOff();
            }
        }
    }

    protected void liftBed(){
        for(Vehicle car: world.vehicles.keySet()) {
            if(car instanceof Scania){
                ((Scania) car).raisePlatformDegree(70);
            }
        }
    }

    protected void lowerBed(){
        for(Vehicle car: world.vehicles.keySet()) {
            if(car instanceof Scania){
                ((Scania) car).lowerPlatformDegree(70);
            }
        }
    }

    protected void startVehicle() {
        for (Vehicle car: world.vehicles.keySet()) {
            car.startEngine();
        }
    }

    protected void stopVehicle() {
        for (Vehicle car: world.vehicles.keySet()) {
            car.stopEngine();
        }
    }

}
