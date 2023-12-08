package model;

public class NotMovableState implements MovableState{

    public double startEngine(){
        return 0;
    }

    public double movable() {
        return 0;
    }


//    @Override
//    public void incrementSpeed(double amount) {
//
//    }


//    @Override
//    public void changeState(Vehicle vehicle) {
//        vehicle.setMovableState(new IsMovableState());
//    }
}
