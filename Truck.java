import java.awt.*;

public class Truck implements Movable{

    private final Car parent;
    private boolean platformDown; //platform down = ramp uppe
    public Truck(int nrOfDoors, double enginePower, Color color, String modelName) {
        this.parent = new Car(nrOfDoors, enginePower, color, modelName);
        platformDown = true;
    }

    protected boolean getPlatformDown(){
        return platformDown;
    }

    protected void raisePlatform() {
        platformDown = false;
    }

    protected void lowerPlatform() {
        platformDown = true;
    }

    protected int getNrDoors(){
        return parent.getNrDoors();
    }

    protected double getEnginePower(){
        return parent.getEnginePower();
    }

    protected double getCurrentSpeed(){
        return parent.getCurrentSpeed();
    }

    protected Color getColor(){
        return parent.getColor();
    }

    protected void setColor(Color clr){
        parent.setColor(clr);
    }

    protected void startEngine(){
        parent.startEngine();
    }

    protected void stopEngine(){
        parent.stopEngine();
    }

    protected double speedFactor() {
        return parent.speedFactor();
    }

    protected void gas(double amount){
        parent.gas(amount);
    }

    protected void brake(double amount) {
        parent.brake(amount);
    }

    @Override
    public void move() {
        if (platformDown) {
            parent.move();
        }
    }

    @Override
    public void turnLeft() {
        parent.turnLeft();
    }

    @Override
    public void turnRight() {
        parent.turnRight();
    }
}
