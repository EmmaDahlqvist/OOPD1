import java.awt.*;

public class Saab95 implements ICar {

    private final VeichleHelper veichleHelper;

    protected boolean turboOn;

    protected Saab95(){
        veichleHelper = new VeichleHelper(2, 125, Color.red, "Saab95");
	    turboOn = false;
    }

    protected void setTurboOn(){
	    turboOn = true;
    }

    protected void setTurboOff(){
	    turboOn = false;
    }

    @Override
    public double getX() {
        return veichleHelper.getX();
    }

    @Override
    public double getY() {
        return veichleHelper.getY();
    }

    @Override
    public int getNrDoors() {
        return veichleHelper.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return veichleHelper.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return veichleHelper.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return veichleHelper.getColor();
    }

    @Override
    public void setColor(Color clr) {
        veichleHelper.setColor(clr);
    }

    @Override
    public void startEngine() {
        veichleHelper.startEngine();
    }

    @Override
    public void stopEngine() {
        veichleHelper.stopEngine();
    }

    @Override
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }

    @Override
    public void gas(double amount) {
        veichleHelper.gas(amount);
    }

    @Override
    public void brake(double amount) {
        veichleHelper.brake(amount);
    }

    @Override
    public void move() {
        veichleHelper.move();
    }

    @Override
    public void turnLeft() {
        veichleHelper.turnLeft();
    }

    @Override
    public void turnRight() {
        veichleHelper.turnRight();
    }
}
