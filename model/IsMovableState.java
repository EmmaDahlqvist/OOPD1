package model;

public class IsMovableState implements MovableState {

    @Override
    public void changeState(Truck truck) {
        truck.setMovableState(new NotMovableState());
    }

    @Override
    public void move() {

    }


}
