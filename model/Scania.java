package model;

import java.awt.*;

public class Scania extends Truck implements SpeedFactorImplementor {

    private int platformDegree;

    protected Scania() {
        super(2, Color.BLUE, "Scania");
        platformDegree = 0;
    }

//    @Override
//    protected MovableState initMovableState() {
//        return new IsMovableState();
//    }

    @Override
    protected VehicleMovementHelper initVehicleHelper() {
        return new VehicleMovementHelper(350, this);
    }

    public int getPlatformDegree(){
        return platformDegree;
    }

    public void raisePlatformDegree(int degree){
        if(getCurrentSpeed() == 0) {
            if (degree >= 0) {
                platformDegree = Math.min(platformDegree + degree, 70);
            }
            platformRaised();
        }
    }

    public void lowerPlatformDegree(int degree){
        if(getCurrentSpeed() == 0) {
            if (degree >= 0) {
                platformDegree = Math.max(platformDegree - degree, 0);
            }
        }
        platformDown();
    }


    public void platformDown(){ //Sätter ett krav på att platformen måste vara nere när denna ska köras
        if(platformDegree == 0){
            super.changeToIsMovableState();
        }
    }


    public void platformRaised(){ //Sätter ett krav på att platforms vinkeln måste vara högre än 0
        if(platformDegree > 0){
            super.changeToNotMovableState();
        }
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }

}

