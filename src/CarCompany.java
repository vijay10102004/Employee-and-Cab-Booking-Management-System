import java.util.HashMap;

public class CarCompany {
    HashMap<Integer,Car> cars;

    public CarCompany() {
        this.cars = new HashMap<>();
    }

    public void addCars(Integer id,Car car)
    {
        cars.put(id,car);
    }

    public HashMap<Integer, Car> getCars() {
        return cars;
    }
}
