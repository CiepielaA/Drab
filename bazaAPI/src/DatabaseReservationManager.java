import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Adrian on 23.01.2017.
 */
public class DatabaseReservationManager {

    private DatabaseConnector databaseConnector;

    public DatabaseReservationManager(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void addReservation(String startDate, int durationInDays, String typeOfReturn, String paymentMethod, int clientId){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement("{call ADDRESERVATION(?, ?, ?, ?, ?)}");
            preparedStatement.setString(1, startDate);
            preparedStatement.setInt(2, durationInDays);
            preparedStatement.setString(3, typeOfReturn);
            preparedStatement.setString(4, paymentMethod);
            preparedStatement.setInt(5, clientId);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("addReservation Error!");
            e.printStackTrace();
        }
    }

    public void deleteReservation(int reservationId){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement("{call DELETEERESERVATION(?)}");
            preparedStatement.setInt(1, reservationId);
            preparedStatement.execute();

        }catch (SQLException e){
            System.out.println("deleteReservation Error!");
            e.printStackTrace();
        }
    }

    public String[] showSpecificReservation(int reservationId){
        try{
            PreparedStatement preparedStatement = databaseConnector.getConnection().prepareStatement(
                    "SELECT * from RESERVATION WHERE RESERVATION_ID =" + reservationId);
            ResultSet resultSet = preparedStatement.executeQuery();
            String reservation[] = new String[5];

            resultSet.next();
            reservation[1] = resultSet.getString(2);
            reservation[2] = resultSet.getString(3);
            reservation[3] = resultSet.getString(4);
            reservation[4] = resultSet.getString(5);
            reservation[5] = resultSet.getString(6);

            return reservation;

        }catch (SQLException e){
            System.out.println("showSpecificReservation Error!");
            e.printStackTrace();
        }
        return null;
    }
    
    
}
