import java.awt.*;

public class Scania extends Car {

    private int platformDegree;

    protected Scania() {
        super(2, 350, Color.BLUE, "Scania");
        platformDegree = 0;
    }

    @Override
    protected double speedFactor() {
        return getEnginePower()*0.01;
    }

    public int getPlatformDegree(){
        return platformDegree;
    }

    protected void raisePlatformDegree(int degree){
        if(getCurrentSpeed() == 0) {
            if (degree >= 0 && platformDegree + degree <= 70) {
                platformDegree += degree;
            } else {
                platformDegree = 70; //du höjde för mycket heh
            }
        }
    }

    protected void lowerPlatformDegree(int degree){
        if(getCurrentSpeed() == 0){
            if(degree >= 0 && platformDegree - degree >= 0){
                platformDegree -= degree;
            } else {
                platformDegree = 0; //du sänkte för mycket heh
            }
        }
    }

    @Override
    public void move(){
        if(platformDegree == 0){ //vinkeln måste va 0 när man rör på sig
            currentX += getCurrentSpeed()*direction.x;
            currentY += getCurrentSpeed()*direction.y;
        }
    }

}

