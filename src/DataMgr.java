import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataMgr {
    private static Connection mealPlanningConnection = null;
    private static Connection arcadeGamesConnection = null;
    private static Connection videoGameSystemsConnection = null;

    private static final String user = "root";
    private static final String password = "rootroot";
    private static final String host = "jdbc:mysql://localhost:3306";

    public static Connection getMealPlanningConnection() {
        if (mealPlanningConnection == null) {
            mealPlanningConnection = createConnection("MealPlanning");
        }
        return mealPlanningConnection;
    }

    public static Connection getArcadeGamesConnection() {
        if(arcadeGamesConnection == null) {
            arcadeGamesConnection = createConnection("ArcadeGames");
        }
        return arcadeGamesConnection;
    }

    public static Connection getVideoGameSystemsConnection() {
        if(videoGameSystemsConnection == null) {
            videoGameSystemsConnection = createConnection("VideoGameSystems");
        }
        return videoGameSystemsConnection;
    }

    public static Connection createConnection(String databaseName) {
        try {
            return DriverManager.getConnection(host + databaseName, user, password);
        } catch (SQLException exception) {
            System.err.println("Failed to connect to " + databaseName + ": " + exception.getMessage());
            exception.printStackTrace();
            return null;
        }
    }

    public static void closeConnections() {
        closeConnection(mealPlanningConnection);
        closeConnection(arcadeGamesConnection);
        closeConnection(videoGameSystemsConnection);
    }

    public static void closeConnection(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException exception) {
                System.err.println("Failed to close connection: " + exception.getMessage());
            }
        }
    }
}



