package repository.customer;

import model.Customer;
import model.CustomerType;
import repository.DBConnection;
import repository.customer_type.CustomerTypeRepositoryImpl;
import service.customer_type.CustomerTypeService;
import service.customer_type.CustomerTypeServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer;";

    CustomerTypeRepositoryImpl customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<Customer> findAllCustomer() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        CustomerType customerType;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
                resultSet = preparedStatement.executeQuery();

                Customer customer;
                while (resultSet.next()) {

                    String id = resultSet.getString("customer_id");
                    int customerTypeId = resultSet.getInt("customer_type_id");
                    customerType = this.customerTypeRepository.findCusTypeById(customerTypeId);
                    String name = resultSet.getString("customer_name");
                    Date birthDay = resultSet.getDate("customer_birthday");
                    int int_gender = resultSet.getInt("customer_gender");
                    boolean gender = (int_gender == 1);
                    String idCard = resultSet.getString("customer_id_card");
                    String phone = resultSet.getString("customer_phone");
                    String email = resultSet.getString("customer_email");
                    String address = resultSet.getString("customer_address");

                    customer = new Customer(id, customerType, name, birthDay, gender, idCard, phone, email, address);

                    customerList.add(customer);
                }
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    preparedStatement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public Customer findCustomerById(String id) {
        return null;
    }

    @Override
    public void update(String id, Customer customer) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public List<Customer> search(String search) {
        return null;
    }

    @Override
    public List<Customer> sortCustomer(String sortBy) {
        return null;
    }
}
