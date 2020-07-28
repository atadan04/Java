package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB{
    private static Connection connection = null;

    private ConnectionDB(){
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            String userName = "root";
            String password = "misha1234E!";
            String url = "jdbc:mysql://localhost:3306/PhoneFromCitilink";
            connection = DriverManager.getConnection(url,userName,password);
        }
        return connection;
    }

    public static void closeConnection() throws SQLException{
        connection.close();
    }

}
