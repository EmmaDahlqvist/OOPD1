package model;

public class VehicleMovementHelper {
    private double enginePower; // model.Engine power of the car
    public double currentSpeed; // The current speed of the car
    protected double currentX;
    protected double currentY;
    protected Direction direction;

    SpeedFactorImplementor vehicle;

    MovableState movableState;

//    MovableState state = new IsMovableState() {
//        @Override
//        public void incrementSpeed(double amount) {
//            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
//        }
//    };

    protected VehicleMovementHelper(double enginePower, SpeedFactorImplementor speedFactorImplementor) {
        this.enginePower = enginePower;
        this.currentX = 0;
        this.currentY = 0;
        this.direction = Direction.EAST;
        this.vehicle = speedFactorImplementor;

        this.movableState = new IsMovableState();

        stopEngine();
    }

    protected void changeToIsMovableState(){
        this.movableState = new IsMovableState();
    }

    protected void changeToNotMovableState(){
        this.movableState = new NotMovableState();
    }

    protected MovableState getMovableState(){
        return this.movableState;
    }

    protected double getX() {
        return currentX;
    }

    protected double getY() {
        return currentY;
    }

    protected void setX(double x) {
        currentX = x;
    }

    protected void setY(double y) {
        currentY = y;
    }

    public Direction getDirection() {
        return direction;
    }

    protected double getEnginePower(){
        return enginePower;
    }

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected void startEngine(){
        currentSpeed = movableState.startEngine();
    }

    protected void stopEngine(){
        currentSpeed = 0;
    }

    protected double speedFactor() {
        return vehicle.speedFactor();
    }

    public void move() {
        currentX += currentSpeed*direction.x * movableState.movable();
        currentY += currentSpeed*direction.y * movableState.movable();
    }

    public void turnLeft() {
        direction = direction.turnLeft();
    }

    public void turnRight() {
        direction = direction.turnRight();
    }

    public void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower) *  movableState.movable();
    }

    public void decrementSpeed(double amount){
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
