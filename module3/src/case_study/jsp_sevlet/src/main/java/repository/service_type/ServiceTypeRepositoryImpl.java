package repository.service_type;

import model.ServiceType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeRepositoryImpl implements ServiceTypeRepository{

    @Override
    public ServiceType findById(int id) {
        return null;
    }
}
