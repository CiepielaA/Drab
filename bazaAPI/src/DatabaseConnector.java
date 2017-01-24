import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Adrian on 23.01.2017.
 */
public class DatabaseConnector {

    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:orcl";

    private Connection connection;
    private Statement statement;

    public void openDatabaseConnection(){
        try {
            Class.forName(DRIVER).newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("LACK OF DRIVER JDBC0");
            e.printStackTrace();
        } catch (InstantiationException e) {
            System.err.println("LACK OF DRIVER JDBC1");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.err.println("LACK OF DRIVER JDBC2");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(DB_URL,"c##adrian", "123");
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem with opening connection");
            e.printStackTrace();
        }
    }

    public void closeDatabaseConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.err.println("Problem with closing connection");
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public Statement getStatement() {
        return statement;
    }
}
