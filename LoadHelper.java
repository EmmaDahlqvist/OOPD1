import java.util.ArrayList;
import java.util.List;

public class LoadHelper<T extends Veichle> {

    private List<T> listOfLoadedCars = new ArrayList<>();

    private final int capacity;

    public LoadHelper(int capacity){
        this.capacity = capacity;
    }


    protected void load(T car){
        if(!listOfLoadedCars.contains(car) && listOfLoadedCars.size() <= capacity){
            listOfLoadedCars.add(car);
        }
    }

    protected void unload(T car){
        listOfLoadedCars.remove(car);
    }

    protected List<T> getListOfLoadedCars() {
        return listOfLoadedCars;
    }
}
