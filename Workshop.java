import java.util.List;

public class Workshop <T extends Veichle> {

    LoadHelper<T> loadHelper;

    public Workshop(int capacity) {
        loadHelper = new LoadHelper<>(capacity);
    }

    protected void load(T car){
        loadHelper.load(car);
    }

    protected void unload(T car){
        loadHelper.unload(car);
    }

    protected List<T> getListOfLoadedCars() {
        return loadHelper.getListOfLoadedCars();
    }
}
