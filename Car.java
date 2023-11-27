import java.awt.*;

public abstract class Car implements Vehicle {

    private final VehicleHelper veichleHelper;

    public boolean loadStatus = false;

    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        veichleHelper = new VehicleHelper(nrDoors, enginePower, color, modelName);

        stopEngine();
    }

    public double getX() {
        return veichleHelper.getX();
    }

    public double getY() {
        return veichleHelper.getY();
    }

    public void setX(double x){
        veichleHelper.setX(x);
    }

    public void setY(double y){
        veichleHelper.setY(y);
    }

    public Direction getDirection() {
        return veichleHelper.getDirection();
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

    public void move() {
        if(!loadStatus){
            veichleHelper.move();
        }
    }

    public void turnLeft() {
        veichleHelper.turnLeft();
    }


    public void turnRight() {
        veichleHelper.turnRight();
    }

    public void gas(double amount){
        veichleHelper.gas(amount);
    }

    public void brake(double amount) {
        veichleHelper.brake(amount);
    }
}