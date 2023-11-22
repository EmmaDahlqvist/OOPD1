import java.awt.*;

public interface Veichle extends Movable {

    void bounceDirection();

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
