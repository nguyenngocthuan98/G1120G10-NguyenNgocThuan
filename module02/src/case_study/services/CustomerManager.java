package case_study.services;

import case_study.commons.FuncReadWrite;
import case_study.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    static FuncReadWrite<Customer> funcReadWrite = new FuncReadWrite<>();

    public void add(Customer customer) {
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        funcReadWrite.writeFile("Customer.csv", list, true);
    }

    public List<Customer> findAll() {
        List<String[]> list = funcReadWrite.readFile("Customer.csv");
        List<Customer> listCustomer = new ArrayList<>();
        for (String[] lines : list) {
            Customer customer = new Customer(lines);
            listCustomer.add(customer);
        }
        return listCustomer;
    }
}
