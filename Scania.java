import java.awt.*;

public class Scania extends Truck {

    private int platformDegree;

    protected Scania() {
        super(2, 350, Color.BLUE, "Scania");
        platformDegree = 0;
    }

    public int getPlatformDegree(){
        return platformDegree;
    }

    protected void raisePlatformDegree(int degree){
        raisePlatformLowerRamp();
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
            lowerPlatformRaiseRamp();
        }
    }

    @Override
    public void lowerPlatformRaiseRamp(){ //Sätter ett krav på att platformen måste vara nere när denna ska köras
        if(platformDegree == 0){
            lowerPlatformRaiseRamp();
        }
    }

    @Override
    public void raisePlatformLowerRamp(){ //Sätter ett krav på att platforms vinkeln måste vara högre än 0
        if(platformDegree > 0){
            raisePlatformLowerRamp();
        }
    }

}

