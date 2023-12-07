package model;

public interface Engine {

    void startEngine();

    void stopEngine();

    double speedFactor();

    double getEnginePower();

    double getCurrentSpeed();

    void gas(double amount);

    void brake(double amount);
}
