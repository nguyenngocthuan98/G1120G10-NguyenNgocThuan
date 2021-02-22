package exercise_vehicle.services;

import exercise_vehicle.common.FuncReadWrite;
import exercise_vehicle.models.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckManager implements CRUDVehicle<Truck> {
    static FuncReadWrite<Truck> funcReadWrite = new FuncReadWrite<>();

    @Override
    public void add(Truck truck) {
        List<Truck> list = new ArrayList<>();
        list.add(truck);
        funcReadWrite.writeFile("xeTai.csv", list, true);
    }

    @Override
    public List<Truck> findAll() {
        List<String[]> list = funcReadWrite.readFile("xeTai.csv");
        List<Truck> truckList = new ArrayList<>();
        for (String[] line : list) {
            Truck truck = new Truck(line);
            truckList.add(truck);
        }
        return truckList;
    }

    @Override
    public Truck findById(String id) {
        List<Truck> list = findAll();
        for (Truck truck : list) {
            if (truck.getNumberId().equals(id)) {
                return truck;
            }
        }
        return null;
    }

    @Override
    public void edit(Truck truck, String id) {

    }

    @Override
    public void delete(String id) {
        List<Truck> list = findAll();
        Truck temp = findById(id);
        list.remove(temp);
        funcReadWrite.writeFile("xeTai.csv", list, false);
    }
}
