import java.awt.*;

public abstract class Car implements Vehicle {

    protected VehicleHelper vehicleHelper;
    protected VehicleMovementHelper vehicleMovementHelper;

    public boolean loadStatus = false;

    protected Car(int nrDoors, Color color, String modelName) {
        vehicleMovementHelper = initVehicleHelper();
        vehicleHelper = new VehicleHelper(nrDoors, color, modelName);

        stopEngine();
    }

    protected abstract VehicleMovementHelper initVehicleHelper();
    public String getModelName() {
        return vehicleHelper.getModelName();
    }

    public double getX() {
        return vehicleMovementHelper.getX();
    }

    public double getY() {
        return vehicleMovementHelper.getY();
    }

    public void setX(double x){
        vehicleMovementHelper.setX(x);
    }

    public void setY(double y){
        vehicleMovementHelper.setY(y);
    }

    public Direction getDirection() {
        return vehicleMovementHelper.getDirection();
    }

    public int getNrDoors(){
        return vehicleHelper.getNrDoors();
    }

    public double getEnginePower(){
        return vehicleMovementHelper.getEnginePower();
    }

    public double getCurrentSpeed(){
        return vehicleMovementHelper.getCurrentSpeed();
    }

    public Color getColor(){
        return vehicleHelper.getColor();
    }

    public void setColor(Color clr){
        vehicleHelper.setColor(clr);
    }

    public void startEngine(){
        vehicleMovementHelper.startEngine();
    }

    public void stopEngine(){
        vehicleMovementHelper.stopEngine();
    }

    public double speedFactor() { return vehicleMovementHelper.speedFactor();
    }

    public void move() {
        if(!loadStatus){
            vehicleMovementHelper.move();
        }
    }

    public void turnLeft() {
        vehicleMovementHelper.turnLeft();
    }


    public void turnRight() {
        vehicleMovementHelper.turnRight();
    }

    public void gas(double amount){
        vehicleMovementHelper.gas(amount);
    }

    public void brake(double amount) {
        vehicleMovementHelper.brake(amount);
    }
}