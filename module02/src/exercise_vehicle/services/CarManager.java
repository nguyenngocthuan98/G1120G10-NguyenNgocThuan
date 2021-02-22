package exercise_vehicle.services;

import exercise_vehicle.common.FuncReadWrite;
import exercise_vehicle.models.Car;

import java.util.ArrayList;
import java.util.List;

public class CarManager implements CRUDVehicle<Car>{
    static FuncReadWrite<Car> funcReadWrite = new FuncReadWrite<>();

    @Override
    public void add(Car car) {
        List<Car> list = new ArrayList<>();
        list.add(car);
        funcReadWrite.writeFile("oto.csv", list, true);
    }

    @Override
    public List<Car> findAll() {
        List<String[]> list = funcReadWrite.readFile("oto.csv");
        List<Car> carList = new ArrayList<>();
        for (String[] line : list){
            Car car = new Car(line);
            carList.add(car);
        }
        return carList;
    }

    @Override
    public Car findById(String id) {
        List<Car> list = findAll();
        for (Car car : list){
            if (car.getNumberId().equals(id)){
                return car;
            }
        }
        return null;
    }

    @Override
    public void edit(Car car, String id) {
        List<Car> list = findAll();
        int index = -1;
        for (int i = 0; i <list.size(); i++){
            if (list.get(i).getNumberId().equals(id)){
                index = i;
                break;
            }
        }
        if (index != -1){
            list.remove(index);
            list.add(index, car);
            funcReadWrite.writeFile("oto.csv", list, false);
        }
    }

    @Override
    public void delete(String id) {
        List<Car> list = findAll();
        Car temp = findById(id);
        list.remove(temp);
        funcReadWrite.writeFile("oto.csv",list,false);
    }
}
