import java.awt.*;

public class Scania implements ITruck {

    private int platformDegree;

    private PlatformHelper platformHelper = new PlatformHelper();

    VeichleHelper veichleHelper;

    protected Scania() {
        veichleHelper = new VeichleHelper(2, 350, Color.BLUE, "Scania");
        platformDegree = 0;
    }

    public int getPlatformDegree(){
        return platformDegree;
    }

    protected void raisePlatformDegree(int degree){
        raisePlatform();
        if (degree >= 0 && platformDegree + degree <= 70) {
            platformDegree += degree;
        } else {
            platformDegree = 70; //du höjde för mycket heh
        }
    }

    protected void lowerPlatformDegree(int degree){
        if(degree >= 0 && platformDegree - degree >= 0){
            platformDegree -= degree;
        } else {
            platformDegree = 0; //du sänkte för mycket heh
        }

        if(platformDegree == 0){
            lowerPlatform();
        }
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
}

