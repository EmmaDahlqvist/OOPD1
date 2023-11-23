import java.awt.*;

public class Saab95 extends Car {


    protected boolean turboOn;

    protected Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;
    }

    protected void setTurboOn(){
        turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }


}
