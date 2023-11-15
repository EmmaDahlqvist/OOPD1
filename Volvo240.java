import java.awt.*;

public class Volvo240 implements ICar {

    private final VeichleHelper veichleHelper;

    private final static double trimFactor = 1.25;

    protected Volvo240() {
        veichleHelper = new VeichleHelper(4,100, Color.black, "Volvo240");
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
        return getEnginePower() * 0.01 * trimFactor;
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
