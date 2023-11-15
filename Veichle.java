import java.awt.*;

public interface Veichle extends Movable {

    double getX();

    double getY();

    int getNrDoors();
    double getEnginePower();

    double getCurrentSpeed();

    Color getColor();

    void setColor(Color clr);

    void startEngine();

    void stopEngine();

    double speedFactor();

    void gas(double amount);

    void brake(double amount);
}
