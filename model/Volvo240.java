package model;

import model.Car;
import model.SpeedFactorImplementor;
import model.VehicleMovementHelper;

import java.awt.*;

public class Volvo240 extends Car implements SpeedFactorImplementor {

    private final static double trimFactor = 1.25;

    protected Volvo240() {
        super(4, Color.black, "Volvo240");
    }

    @Override
    protected VehicleMovementHelper initVehicleHelper() {
         return new VehicleMovementHelper(100, this);
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
