package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

    public static final String DB_URL = "jdbc:postgresql://localhost/Transport";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "12345";
    public static final String DB_DRIVER = "org.postgresql.Driver";

    public Connection getConnection() {

        Connection connection = null;

        try {

            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Connection is succesfull!");

        } catch (ClassNotFoundException | SQLException e) {

            e.printStackTrace();
            System.out.println("Connection is not successfull!");
        }

        return connection;
    }


}
