package model;

import model.Car;

import java.awt.*;
import java.util.List;

public class BigRig extends Truck implements SpeedFactorImplementor {

    private LoadHelper<Car> loadHelper;

    private final int distanceFromBigRig = 3;

    public BigRig(int capacity) {
        super(2, Color.black, "BiggestRig");
        loadHelper = new LoadHelper<>(capacity);
    }

    @Override
    protected VehicleMovementHelper initVehicleHelper() {
        return new VehicleMovementHelper(350, this);
    }


    protected void loadCar(Car car){
        if(super.getMovableState() instanceof NotMovableState) {
            double xDistance = Math.abs(getX() - car.getX());
            double yDistance = Math.abs(getY() - car.getY());
            if(xDistance <= distanceFromBigRig && yDistance <= distanceFromBigRig) {
                loadHelper.load(car);
                car.changeToNotMovableState();
                double truckPosX = getX();
                double truckPosY = getY();
                car.setX(truckPosX);
                car.setY(truckPosY);
            }
        }
    }

    protected void unloadCar(){
        if(super.getMovableState() instanceof NotMovableState && !loadHelper.getListOfLoadedCars().isEmpty()){
            Car car = loadHelper.getListOfLoadedCars().get(loadHelper.getListOfLoadedCars().size() - 1);
            car.changeToIsMovableState();
            loadHelper.unload(car);
            car.setX(car.getX() + distanceFromBigRig);
            car.setY(car.getY() + distanceFromBigRig);
        }
    }


    @Override
    public void move(){
        super.move();
        for(Car car : loadHelper.getListOfLoadedCars()){
            double truckPosX = getX();
            double truckPosY = getY();
            car.setX(truckPosX);
            car.setY(truckPosY);
        }
    }

    public List<Car> getListOfLoadedCars() {
        return loadHelper.getListOfLoadedCars();
    }

    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01;
    }
}
