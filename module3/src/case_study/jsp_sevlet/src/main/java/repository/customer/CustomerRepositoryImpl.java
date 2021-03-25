package repository.customer;

import model.Customer;
import model.CustomerType;
import repository.DBConnection;
import repository.customer_type.CustomerTypeRepositoryImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    public static final String SELECT_ALL_CUSTOMER = "SELECT * FROM customer;";
    private static final String CREATE_CUSTOMER =
            "INSERT INTO customer(customer_id,customer_type_id,customer_name," +
                    "customer_birthday,customer_gender,customer_id_card," +
                    "customer_phone,customer_email,customer_address)" +
                    "values (?, ?, ? ,?, ?, ? ,?, ?, ?);";
    private static final String DELETE_CUSTOMER = "DELETE FROM customer WHERE customer_id = ?;";

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
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(CREATE_CUSTOMER);
                preparedStatement.setString(1, customer.getCustomerId());
                preparedStatement.setInt(2, customer.getCustomerType().getCustomerTypeId());
                preparedStatement.setString(3, customer.getCustomerName());
                preparedStatement.setString(4, customer.getCustomerBirthday().toString());
                preparedStatement.setInt(5, (customer.isCustomerGender()) ? 1 : 0);
                preparedStatement.setString(6, customer.getCustomerIdCard());
                preparedStatement.setString(7, customer.getCustomerPhone());
                preparedStatement.setString(8, customer.getCustomerEmail());
                preparedStatement.setString(9, customer.getCustomerAddress());

                preparedStatement.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.close();
            }
        }
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
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_CUSTOMER);
                statement.setString(1, id);

                statement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
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
