import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataMgr
{
    // Method to get a connection to the MealPlanning database
    public Connection getMealPlanningConnection(String user, String password) {
        return getConnection("MealPlanning", user, password);
    }

    // Method to get a connection to the ArcadeGames database
    public Connection getArcadeGamesConnection(String user, String password) {
        return getConnection("ArcadeGames", user, password);
    }

    // Method to get a connection to the VideoGameSystems database
    public Connection getVideoGameSystemsConnection(String user, String password) {
        return getConnection("VideoGameSystems", user, password);
    }

    // A generic method to connect to any database given the database name, user, and password
    private Connection getConnection(String databaseName, String user, String password) {
        try {
            // Return the connection to the specific database
            String url = "jdbc:mysql://localhost:3306/" + databaseName;  // Adjust the URL as needed
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException exception) {
            // Handle the exception if the connection fails
            System.out.println("Failed to connect to the " + databaseName + " database: " + exception.getMessage());
            return null;
        }
    }
}
