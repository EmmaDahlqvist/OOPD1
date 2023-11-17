import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BigRig extends Truck{

    LoadHelper<Car> loadHelper;

    public BigRig(int nrOfDoors, double enginePower, Color color, String modelName, int capacity) {
        super(nrOfDoors, enginePower, color, modelName);
        loadHelper = new LoadHelper<>(capacity);
    }

    protected void loadCar(Car car){
        if(!getPlatformDownRampUp()) {
            double xDistance = Math.abs(getX() - car.getX());
            double yDistance = Math.abs(getY() - car.getY());
            if(xDistance <= 3.0 && yDistance <= 3.0) {
                loadHelper.load(car);
                car.loadStatus = true;
                double truckPosX = getX();
                double truckPosY = getY();
                car.setX(truckPosX);
                car.setY(truckPosY);
            }
        }
    }

    protected void unloadCar(){
        if(!getPlatformDownRampUp() && !loadHelper.getListOfLoadedCars().isEmpty()){
            Car car = loadHelper.getListOfLoadedCars().get(loadHelper.getListOfLoadedCars().size() - 1);
            car.loadStatus = false;
            loadHelper.unload(car);
            car.setX(car.getX() + 3);
            car.setY(car.getY() + 3);
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
}
