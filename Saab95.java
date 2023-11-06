import java.awt.*;
import java.util.Iterator;

public class Saab95 extends Cars implements Movable{

    public boolean turboOn;

    public Saab95(){
        super(2, 125, Color.red, "Saab95");
	    turboOn = false;
    }

    public void setTurboOn(){
	    turboOn = true;
    }

    public void setTurboOff(){
	    turboOn = false;
    }

    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }

    public void incrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() + speedFactor() * amount;
    }

    public void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;
    }


    @Override
    public void move() {
        currentX = currentSpeed*dir.get(direction)[0];
        currentY = currentSpeed*dir.get(direction)[1];
    }

    @Override
    public void turnLeft() {
        if(direction == "N"){
            direction = "W";
        } else if(direction == "W"){
            direction = "S";
        } else if (direction == "S"){
            direction = "E";
        } else if (direction == "E"){
            direction = "N";
        }
        /*if direction[0] == 0:
        *   if direction[1] == 1:
        *       direction[0] = -1
        *   else:
        *       direction[0] = 1
        *   direction[1] = 0
        * else:
        *   if direction[0] == 1:
        *       direction[1] = 1
        *   else:
        *       direction[1] = -1
        *   direction[0] = 0
        */
    }

    @Override
    public void turnRight() {

    }

}
