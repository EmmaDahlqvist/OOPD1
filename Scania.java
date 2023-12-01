import java.awt.*;

public class Scania extends Truck implements SpeedFactorImplementor{

    private int platformDegree;

    protected Scania() {
        platformDegree = 0;
    }

    @Override
    protected VehicleHelper initVehicleHelper() {
        return new VehicleHelper(2, 350, Color.BLUE, "Scania", this);
    }

    public int getPlatformDegree(){
        return platformDegree;
    }

    protected void raisePlatformDegree(int degree){
        if(getCurrentSpeed() == 0) {
            if (degree >= 0) {
                platformDegree = Math.min(platformDegree + degree, 70);
            }
            raisePlatformLowerRamp();
        }
    }

    protected void lowerPlatformDegree(int degree){
        if(getCurrentSpeed() == 0) {
            if (degree >= 0) {
                platformDegree = Math.max(platformDegree - degree, 0);
            }
        }
        lowerPlatformRaiseRamp();
    }

    @Override
    public void lowerPlatformRaiseRamp(){ //Sätter ett krav på att platformen måste vara nere när denna ska köras
        if(platformDegree == 0){
            super.lowerPlatformRaiseRamp();
        }
    }

    @Override
    public void raisePlatformLowerRamp(){ //Sätter ett krav på att platforms vinkeln måste vara högre än 0
        if(platformDegree > 0){
            super.raisePlatformLowerRamp();
        }
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

}

