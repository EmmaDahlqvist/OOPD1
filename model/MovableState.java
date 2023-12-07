package model;

public interface MovableState {
    void changeState(Vehicle vehicle);

    void gas(double amount);

    void incrementSpeed(Vehicle vehicle, double amount);

}
