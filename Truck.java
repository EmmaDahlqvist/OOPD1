import java.awt.*;

public class Truck implements Veichle{

    private final VeichleHelper veichleHelper;
    private boolean platformDownRampUp; //platform down = ramp uppe
    public Truck(int nrOfDoors, double enginePower, Color color, String modelName) {
        veichleHelper = new VeichleHelper(nrOfDoors, enginePower, color, modelName);
        platformDownRampUp = true;
    }
    public void bounceDirection() {
        veichleHelper.bounceDirection();
    }

    protected boolean getPlatformDownRampUp(){
        return platformDownRampUp;
    }

    protected void raisePlatformLowerRamp() {
        platformDownRampUp = false;
    }

    protected void lowerPlatformRaiseRamp() {
        platformDownRampUp = true;
    }

    public double getX() {
        return veichleHelper.getX();
    }

    public double getY() {
        return veichleHelper.getY();
    }

    public void setX(double x) {
        veichleHelper.setX(x);
    }

    public void setY(double y) {
        veichleHelper.setY(y);
    }

    public int getNrDoors(){
        return veichleHelper.getNrDoors();
    }

    public double getEnginePower(){
        return veichleHelper.getEnginePower();
    }

    public double getCurrentSpeed(){
        return veichleHelper.getCurrentSpeed();
    }

    public Color getColor(){
        return veichleHelper.getColor();
    }

    public void setColor(Color clr){
        veichleHelper.setColor(clr);
    }

    public void startEngine(){
        veichleHelper.startEngine();
    }

    public void stopEngine(){
        veichleHelper.stopEngine();
    }

    public double speedFactor() {
        return veichleHelper.speedFactor();
    }

    public void gas(double amount){
        veichleHelper.gas(amount);
    }

    public void brake(double amount) {
        veichleHelper.brake(amount);
    }


    public void move() {
        if (platformDownRampUp) {
            veichleHelper.move();
        }
    }

    public void turnLeft() {
        veichleHelper.turnLeft();
    }


    public void turnRight() {
        veichleHelper.turnRight();
    }
}
