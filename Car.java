import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

public class Car implements Veichle {

    private final VeichleHelper veichleHelper;

    public boolean loadStatus = false;

    protected Car(int nrDoors, double enginePower, Color color, String modelName) {
        veichleHelper = new VeichleHelper(nrDoors, enginePower, color, modelName);

        stopEngine();
    }

    public void bounceDirection() {
        veichleHelper.bounceDirection();
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
        return veichleHelper.direction;
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