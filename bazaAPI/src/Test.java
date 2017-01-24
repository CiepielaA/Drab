/**
 * Created by Adrian on 23.01.2017.
 */
public class Test {

    public static void main(String[] args) {
        DatabaseAPI databaseAPI = new DatabaseAPI();

        databaseAPI.openDatabaseConnection();
        databaseAPI.closeDatabaseConnection();

    }

}
