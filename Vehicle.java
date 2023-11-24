import java.awt.*;

public interface Vehicle extends Movable {

    double getX();

    double getY();

    void setX(double x);

    void setY(double y);

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
