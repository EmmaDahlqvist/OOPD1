package model;

import model.Car;

import java.awt.*;

public class Saab95 extends Car implements SpeedFactorImplementor {


    protected boolean turboOn;

    protected Saab95(){
        super(2, Color.red, "Saab95");
	    turboOn = false;
    }

    @Override
    protected VehicleMovementHelper initVehicleHelper() {
        return new VehicleMovementHelper(125, this);
    }

    public void setTurboOn(){
        turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
