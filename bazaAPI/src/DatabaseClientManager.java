import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Adrian on 23.01.2017.
 */
public class DatabaseClientManager {

    private DatabaseConnector databaseConnector;

    public DatabaseClientManager(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void addClient(String firstName, String lastName, String address){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement("{call ADDCLIENT(?,?,?)}");
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, address);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("addClient Error!");
            e.printStackTrace();
        }
    }

    public void deleteClient(int clientId){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement("{call DELETECUSTOMER(?)}");
            preparedStatement.setInt(1, clientId);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("deleteClient Error!");
            e.printStackTrace();
        }
    }

    public String[] showSpecificClient(int clientId){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(
                    "SELECT * from CLIENT WHERE CLIENT_ID =" + clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String client[] = new String[3];

            resultSet.next();

            client[1] = resultSet.getString(2);
            client[2] = resultSet.getString(3);
            client[3] = resultSet.getString(4);

            return client;

        }catch (SQLException e){
            System.out.println("showSpecificClient Error!");
            e.printStackTrace();
        }
        return null;
    }

}
