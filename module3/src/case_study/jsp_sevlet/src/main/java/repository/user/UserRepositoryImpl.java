package repository.user;

import model.User;
import repository.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepositoryImpl implements UserRepository{

    @Override
    public void createAccount(String username) {

    }

    @Override
    public User findByUserName(String username) {
        return null;
    }

    @Override
    public void update(String username, String password) {

    }
}
