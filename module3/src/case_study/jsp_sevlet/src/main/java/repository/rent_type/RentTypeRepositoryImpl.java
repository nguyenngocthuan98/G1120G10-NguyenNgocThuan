package repository.rent_type;

import model.RentType;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentTypeRepositoryImpl implements RentTypeRepository{

    @Override
    public RentType findById(int id) {
        return null;
    }
}
