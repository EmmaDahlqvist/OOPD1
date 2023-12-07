package model;

public class NotMovableState implements MovableState{


    public void gas(double amount){
        //TOM
    }

    @Override
    public void incrementSpeed(double amount) {

    }


    @Override
    public void changeState(Vehicle vehicle) {
        vehicle.setMovableState(new IsMovableState());
    }
}
