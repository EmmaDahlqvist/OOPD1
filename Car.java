import java.awt.*;

public abstract class Car implements Vehicle {

    protected VehicleHelper vehicleHelper;

    public boolean loadStatus = false;

    protected Car() {
        vehicleHelper = initVehicleHelper();

        stopEngine();
    }

    protected abstract VehicleHelper initVehicleHelper();

    public double getX() {
        return vehicleHelper.getX();
    }

    public double getY() {
        return vehicleHelper.getY();
    }

    public void setX(double x){
        vehicleHelper.setX(x);
    }

    public void setY(double y){
        vehicleHelper.setY(y);
    }

    public Direction getDirection() {
        return vehicleHelper.getDirection();
    }

    public int getNrDoors(){
        return vehicleHelper.getNrDoors();
    }

    public double getEnginePower(){
        return vehicleHelper.getEnginePower();
    }

    public double getCurrentSpeed(){
        return vehicleHelper.getCurrentSpeed();
    }

    public Color getColor(){
        return vehicleHelper.getColor();
    }

    public void setColor(Color clr){
        vehicleHelper.setColor(clr);
    }

    public void startEngine(){
        vehicleHelper.startEngine();
    }

    public void stopEngine(){
        vehicleHelper.stopEngine();
    }

    public double speedFactor() {
        return vehicleHelper.speedFactor();
    }

    public void move() {
        if(!loadStatus){
            vehicleHelper.move();
        }
    }

    public void turnLeft() {
        vehicleHelper.turnLeft();
    }


    public void turnRight() {
        vehicleHelper.turnRight();
    }

    public void gas(double amount){
        vehicleHelper.gas(amount);
    }

    public void brake(double amount) {
        vehicleHelper.brake(amount);
    }
}