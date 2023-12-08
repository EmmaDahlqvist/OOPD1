package model;

public class IsMovableState implements MovableState {

    public double startEngine(){
        return 0.1;
    }

    public double movable() {
        return 1;
    }





/*
    }
    protected IsMovableState() {

    }
    @Override
    public void changeState(Vehicle vehicle) {
        vehicle.setMovableState(new NotMovableState() );
    }


    public void incrementSpeed(Vehicle vehicle, double amount) {
        vehicle.incrementSpeed(amount);
    }


    public void gas(double amount){
        if(amount >= 0 && amount <= 1){
            incrementSpeed(amount);
        }
    }*/



}
