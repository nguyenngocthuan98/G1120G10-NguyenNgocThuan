package case_study.services;

import java.util.List;

public interface CRUDServices<T> {
    void add(T t); // create

    List<T> findAll(); // read all

    T findById(String id); // read one

    void edit(T t, String id); // update

    void delete(String id); // delete

}
