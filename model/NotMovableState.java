package model;

public class NotMovableState implements MovableState{


    @Override
    public void changeState(Truck truck) {
        truck.setMovableState(new IsMovableState());
    }

    @Override
    public void move() {

    }
}
