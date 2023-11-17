import java.util.ArrayList;
import java.util.List;

public class Workshop <T extends Veichle> {

    private List<T> listOfLoadedCars = new ArrayList<>();


    protected void load(T car){
        if(!listOfLoadedCars.contains(car)){
            listOfLoadedCars.add(car);
        }
    }

    protected T unload(T car){
        if(listOfLoadedCars.contains(car)){
            listOfLoadedCars.remove(car);
            return car;
        }
        return null;
    }


    protected List<T> getListOfLoadedCars() {
        return listOfLoadedCars;
    }
}
