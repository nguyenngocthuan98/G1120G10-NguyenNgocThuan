package exercise_vehicle.services;

import exercise_vehicle.common.FuncReadWrite;
import exercise_vehicle.models.Motorbike;

import java.util.ArrayList;
import java.util.List;

public class MotorbikeManager implements CRUDVehicle<Motorbike> {
    static FuncReadWrite<Motorbike> funcReadWrite = new FuncReadWrite<>();


    @Override
    public void add(Motorbike motorbike) {
        List<Motorbike> list = new ArrayList<>();
        list.add(motorbike);
        funcReadWrite.writeFile("xeMay.csv", list, true);
    }

    @Override
    public List<Motorbike> findAll() {
        List<String[]> list = funcReadWrite.readFile("xeMay.csv");
        List<Motorbike> motorbikeList = new ArrayList<>();
        for (String[] line : list) {
            Motorbike motorbike = new Motorbike();
            motorbikeList.add(motorbike);
        }
        return motorbikeList;
    }

    @Override
    public Motorbike findById(String id) {
        List<Motorbike> list = findAll();
        for (Motorbike motorbike : list) {
            if (motorbike.getNumberId().equals(id)) {
                return motorbike;
            }
        }
        return null;
    }

    @Override
    public void edit(Motorbike motorbike, String id) {

    }

    @Override
    public void delete(String id) {
        List<Motorbike> list = findAll();
        Motorbike temp = findById(id);
        list.remove(temp);
        funcReadWrite.writeFile("xeMay.csv", list, false);
    }
}
