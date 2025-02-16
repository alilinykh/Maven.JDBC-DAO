import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static final String URL = "jdbc:mysql://localhost:3306/daolab";
    public static final String USER = "root";
    public static final String PASS = "1q2w3e4r5t";

    public static Connection getConnection() {
        try {
            //DriverManager.registerDriver(new Driver());
            return DriverManager.getConnection(URL,USER,PASS);
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to DBC", e);
        }
    }

    public static void main(String[] args) {
        Connection connection = ConnectionFactory.getConnection();
    }
}
