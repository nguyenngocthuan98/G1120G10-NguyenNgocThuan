package repository;

import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    public static final String INSERT_USER_VALUE = "INSERT INTO users(`name`, email, country) VALUE (?, ?, ?);";
    public static final String GET_ALL_USER = "SELECT * FROM users;";
    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?;";
    public static final String UPDATE_USER = "UPDATE users SET `name` = ?, email = ? , country = ? WHERE id = ?;";
    public static final String DELETE_USER = "DELETE FROM users WHERE id = ?;";

    @Override
    public void create(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(INSERT_USER_VALUE);

                preparedStatement.setString(1, user.getName()); // setString(index-of-value-in-INSERT_USER_VALUE, ...);
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());

                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.closeConnection();
            }
        }
    }

    @Override
    public User findById(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            resultSet = preparedStatement.executeQuery();

            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String country = resultSet.getString("country");
            User user = new User(name, email, country);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            DBConnection.closeConnection();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<User> userList = new ArrayList<>();
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(GET_ALL_USER);
                resultSet = preparedStatement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");

                    user = new User(id, name, email, country);
                    userList.add(user);
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
                DBConnection.closeConnection();
            }
        }
        return userList;
    }

    @Override
    public void update(User user) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(UPDATE_USER);

                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.setInt(4, user.getId());

                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.closeConnection();
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        if (connection != null) {
            try {
                preparedStatement = connection.prepareStatement(DELETE_USER);
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                DBConnection.closeConnection();
            }
        }
    }
}
