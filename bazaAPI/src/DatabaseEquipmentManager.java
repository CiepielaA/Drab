import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Adrian on 23.01.2017.
 */
public class DatabaseEquipmentManager {

    private DatabaseConnector databaseConnector;

    public DatabaseEquipmentManager(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void addEquipment(String type, String brand, String model, String yearOfProduction, String description){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement("{call ADDEQUIPMENT(?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, type);
            preparedStatement.setString(2, brand);
            preparedStatement.setString(3, model);
            preparedStatement.setString(4, yearOfProduction);
            preparedStatement.setString(5, description);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("addEquipment Error!");
            e.printStackTrace();
        }
    }

    public void deleteEquipment(int equipmentId){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement("{call DELETEEQUIPMENT(?)}");
            preparedStatement.setInt(1, equipmentId);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("deleteEquipment Error!");
            e.printStackTrace();
        }
    }

    public String[] showSpecificEquipment(int equipmentId){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(
                    "SELECT * from EQUIPMENT WHERE EQUIPMENT_ID =" + equipmentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String equipment[] = new String[5];

            resultSet.next();
            equipment[1] = resultSet.getString(2);
            equipment[2] = resultSet.getString(3);
            equipment[3] = resultSet.getString(4);
            equipment[4] = resultSet.getString(5);
            equipment[5] = resultSet.getString(6);

            return equipment;

        }catch (SQLException e){
            System.out.println("showSpecificEquipment Error!");
            e.printStackTrace();
        }
        return null;
    }
}
