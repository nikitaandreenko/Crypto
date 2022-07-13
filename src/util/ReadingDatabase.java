package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ReadingDatabase {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/store";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "nikita2632871";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println("Connection ERROR");
        }
        return connection;
    }

}
