package repository.customer_type;

import model.CustomerType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository{

    @Override
    public CustomerType findCusTypeById(int id) {
        return null;
    }
}
