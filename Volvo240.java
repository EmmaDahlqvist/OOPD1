import java.awt.*;

public class Volvo240 extends Car implements SpeedFactorImplementor{

    private final static double trimFactor = 1.25;

    protected Volvo240() {
        //vehicleHelper = new VehicleHelper(4, 100, Color.black, "Volvo240", this);
    }

    @Override
    protected VehicleHelper initVehicleHelper() {
         return new VehicleHelper(4, 100, Color.black, "Volvo240", new SpeedFactorImplementor() {
             @Override
             public double speedFactor() {
                 return Volvo240.this.speedFactor();
             }
         });
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
