package exercise_vehicle.services;

import java.util.List;

public interface CRUDVehicle<T> {
    void add(T t);

    List<T> findAll();

    T findById(String id); // read one

    void edit(T t, String id); // update

    void delete(String id); // delete

}
