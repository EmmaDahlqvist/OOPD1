package model;

import java.awt.*;

public abstract class Truck implements Vehicle {

    protected VehicleHelper vehicleHelper;
    protected VehicleMovementHelper vehicleMovementHelper;

    private boolean platformDownRampUp; //platform down = ramp uppe
    public Truck(int nrDoors, Color color, String modelName) {
        vehicleMovementHelper = initVehicleHelper();
        vehicleHelper = new VehicleHelper(nrDoors, color, modelName);

        platformDownRampUp = true;
    }

    protected abstract VehicleMovementHelper initVehicleHelper();

    public String getModelName() {
        return vehicleHelper.getModelName();
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
        return vehicleMovementHelper.getX();
    }

    public double getY() {
        return vehicleMovementHelper.getY();
    }

    public void setX(double x) {
        vehicleMovementHelper.setX(x);
    }

    public void setY(double y) {
        vehicleMovementHelper.setY(y);
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

    public double speedFactor() {
        return vehicleMovementHelper.speedFactor();
    }

    public void gas(double amount){
        if(platformDownRampUp){
            vehicleMovementHelper.gas(amount);
        }
    }

    public void brake(double amount) {
        vehicleMovementHelper.brake(amount);
    }

    public void move() {
        vehicleMovementHelper.move();
    }

    public void turnLeft() {
        vehicleMovementHelper.turnLeft();
    }

    public void turnRight() {
        vehicleMovementHelper.turnRight();
    }

    protected MovableState state = new IsMovableState();

    public void setMovableState(MovableState movableState){
        state = movableState;
    }
}
