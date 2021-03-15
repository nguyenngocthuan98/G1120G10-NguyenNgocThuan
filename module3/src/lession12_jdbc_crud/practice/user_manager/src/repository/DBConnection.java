package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "tgnaboas5";
    public static final String HOST = "localhost";
    public static final String DATABASE = "db_jdbc_crud";
    public static final String PORT = "3306";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE, USER_NAME, PASSWORD
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
