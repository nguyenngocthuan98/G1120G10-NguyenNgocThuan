package repository;

import model.Customer;

import java.util.List;

public interface CustomerRepository {
    void create(Customer customer);

    Customer findById(int id);

    List<Customer> findAll();

    void update(int id, Customer customer);

    void remove(int id);
}
