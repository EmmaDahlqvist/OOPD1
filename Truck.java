import java.awt.*;

public abstract class Truck implements Vehicle {

    protected VehicleHelper vehicleHelper;

    private boolean platformDownRampUp; //platform down = ramp uppe
    public Truck() {
        vehicleHelper = initVehicleHelper();

        platformDownRampUp = true;
    }

    protected abstract VehicleHelper initVehicleHelper();

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
        return vehicleHelper.getX();
    }

    public double getY() {
        return vehicleHelper.getY();
    }

    public void setX(double x) {
        vehicleHelper.setX(x);
    }

    public void setY(double y) {
        vehicleHelper.setY(y);
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

    public void gas(double amount){
        if(platformDownRampUp){
            vehicleHelper.gas(amount);
        }
    }

    public void brake(double amount) {
        vehicleHelper.brake(amount);
    }


    public void move() {
        vehicleHelper.move();
    }

    public void turnLeft() {
        vehicleHelper.turnLeft();
    }


    public void turnRight() {
        vehicleHelper.turnRight();
    }
}
