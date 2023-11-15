import java.awt.*;

public class VeichleHelper {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    protected double currentX;
    protected double currentY;
    protected Direction direction;

    protected VeichleHelper(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.currentX = 0;
        this.currentY = 0;
        this.direction = Direction.NORTH;

        stopEngine();
    }


    protected double getX() {
        return currentX;
    }

    protected double getY() {
        return currentY;
    }

    protected int getNrDoors(){
        return nrDoors;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected Color getColor(){
        return color;
    }

    protected void setColor(Color clr){
        color = clr;
    }

    protected void startEngine(){
        currentSpeed = 0.1;
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    protected double speedFactor() {
        return getEnginePower()*0.01;
    }

    public void move() {
        currentX += currentSpeed*direction.x;
        currentY += currentSpeed*direction.y;
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    protected void gas(double amount){
        if(amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }

    protected void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }
}
