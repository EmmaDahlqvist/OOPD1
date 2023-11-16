import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BigRig extends Truck{

    List<Car> listOfLoadedCars = new ArrayList<>();

    public BigRig(int nrOfDoors, double enginePower, Color color, String modelName) {
        super(nrOfDoors, enginePower, color, modelName);
    }

    protected void loadCar(Car car){
        if(!getPlatformDownRampUp()) {
            double xDistance = Math.abs(getX() - car.getX());
            double yDistance = Math.abs(getY() - car.getY());
            if(xDistance <= 3.0 && yDistance <= 3.0) {
                listOfLoadedCars.add(car);
                car.loadStatus = true;
                double truckPosX = getX();
                double truckPosY = getY();
                car.setX(truckPosX);
                car.setY(truckPosY);
            }
        }
    }

    protected void unloadCar(){ //Ska den ta ett argument egentligen??
        if(!getPlatformDownRampUp()){
            Car car = listOfLoadedCars.get(listOfLoadedCars.size() - 1);
            car.loadStatus = false;
            listOfLoadedCars.remove(car);
            car.setX(car.getX() + 3);
            car.setY(car.getY() + 3);
        }
    }

    @Override
    public void move(){
        super.move();
        for(Car car : listOfLoadedCars){
            double truckPosX = getX();
            double truckPosY = getY();
            car.setX(truckPosX);
            car.setY(truckPosY);
        }
    }

    public List<Car> getListOfLoadedCars() {
        return listOfLoadedCars;
    }
}
