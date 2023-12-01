import java.awt.*;

public class Saab95 extends Car implements SpeedFactorImplementor{


    protected boolean turboOn;

    protected Saab95(){
        //super(2, 125, Color.red, "Saab95");
	    turboOn = false;
    }

    @Override
    protected VehicleHelper initVehicleHelper() {
        return new VehicleHelper(2, 125, Color.red, "Saab95", this);
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        System.out.println("saabs speed körs");
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
