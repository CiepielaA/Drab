/**
 * Created by Adrian on 23.01.2017.
 */
public class DatabaseAPI {

    private DatabaseConnector databaseConnector;
    private DatabaseClientManager databaseClientManager;
    private DatabaseEquipmentManager databaseEquipmentManager;
    private DatabaseReservationManager databaseReservationManager;

    public DatabaseAPI(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
        databaseClientManager = new DatabaseClientManager(databaseConnector);
        databaseEquipmentManager = new DatabaseEquipmentManager(databaseConnector);
        databaseReservationManager = new DatabaseReservationManager(databaseConnector);

        databaseConnector.openDatabaseConnection();
    }

    public void addClient(String firstName, String lastName, String address){
        databaseClientManager.addClient(firstName, lastName, address);
    }

    public void deleteClient(int clientId){
        databaseClientManager.deleteClient(clientId);
    }

    public String[] showSpecificClient(int clientId){
        return databaseClientManager.showSpecificClient(clientId);
    }

    public void addEquipment(String type, String brand, String model, String yearOfProduction, String description){
        databaseEquipmentManager.addEquipment(type, brand, model, yearOfProduction, description);
    }

    public void deleteEquipment(int equipmentId){
        databaseEquipmentManager.deleteEquipment(equipmentId);
    }

    public String[] showSpecificEquipment(int equipmentId){
        return databaseEquipmentManager.showSpecificEquipment(equipmentId);
    }

    public void addReservation(String startDate, int durationInDays, String typeOfReturn, String paymentMethod, int clientId){
        databaseReservationManager.addReservation(startDate, durationInDays, typeOfReturn, paymentMethod, clientId);
    }

    public void deleteReservation(int reservationId){
        databaseReservationManager.deleteReservation(reservationId);
    }

    public String[] showSpecificReservation(int reservationId){
        return databaseReservationManager.showSpecificReservation(reservationId);
    }

    public DatabaseClientManager getDatabaseClientManager() {
        return databaseClientManager;
    }

    public DatabaseEquipmentManager getDatabaseEquipmentManager() {
        return databaseEquipmentManager;
    }

    public DatabaseReservationManager getDatabaseReservationManager() {
        return databaseReservationManager;
    }
}
