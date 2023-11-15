import java.awt.*;

public class BigRig implements ITruck {

    private final VeichleHelper veichleHelper;

    private PlatformHelper platformHelper = new PlatformHelper();

    public BigRig(int nrOfDoors, double enginePower, Color color, String modelName) {
        veichleHelper = new VeichleHelper(nrOfDoors, enginePower, color, modelName);
    }

    protected void LoadCar(Car car){
//        if();
    }

    @Override
    public void move() {
        if(!getPlatformDown()){
            veichleHelper.move();
        }
    }

    @Override
    public void turnLeft() {
        veichleHelper.turnLeft();
    }

    @Override
    public void turnRight() {
        veichleHelper.turnRight();
    }

    @Override
    public double getX() {
        return veichleHelper.getX();
    }

    @Override
    public double getY() {
        return veichleHelper.getY();
    }

    @Override
    public int getNrDoors() {
        return veichleHelper.getNrDoors();
    }

    @Override
    public double getEnginePower() {
        return veichleHelper.getEnginePower();
    }

    @Override
    public double getCurrentSpeed() {
        return veichleHelper.getCurrentSpeed();
    }

    @Override
    public Color getColor() {
        return veichleHelper.getColor();
    }

    @Override
    public void setColor(Color clr) {
        veichleHelper.setColor(clr);
    }

    @Override
    public void startEngine() {
        veichleHelper.startEngine();
    }

    @Override
    public void stopEngine() {
        veichleHelper.stopEngine();
    }

    @Override
    public double speedFactor() {
        return veichleHelper.speedFactor();
    }

    @Override
    public void gas(double amount) {
        veichleHelper.gas(amount);
    }

    @Override
    public void brake(double amount) {
        veichleHelper.brake(amount);
    }

    @Override
    public boolean getPlatformDown() {
        return platformHelper.getPlatformDown();
    }

    @Override
    public void raisePlatform() {
        platformHelper.raisePlatform();
    }

    @Override
    public void lowerPlatform() {
        platformHelper.lowerPlatform();
    }
}
