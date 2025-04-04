// Author:  Wendy-Beth Minton
// Class:   3810 Database
// Lab:     Introduction to Database Connectivity

// This is an example of a presentation layer. Notice it includes all the needed prompts needed.
// This class also happens to have the main method. It is common to have the entry to a program 
// exist in the presentation layer, and actually each application tends to have its own entry point,
// if the program/product has multiple applications. 

import java.sql.Connection;
import java.util.Scanner;

public class IntroToPresentationLayer
{
    public static void main(String[] args)
    {
        Scanner userInformation = new Scanner(System.in);
        System.out.println("Enter username and password:");
        // String input
        String userName = userInformation.nextLine();
        String password = userInformation.nextLine();

        // Let's start simple. How do we connect to and access a database?
        // Well, the presentation layer can't do it. We need an instance of the DAL!
        DataMgr dataMgr = new DataMgr();

        // Get connections to the different databases
        Connection mealPlanningConnection = dataMgr.getMealPlanningConnection(userName, password);
        Connection arcadeGamesConnection = dataMgr.getArcadeGamesConnection(userName, password);
        Connection videoGameSystemsConnection = dataMgr.getVideoGameSystemsConnection(userName, password);


        // Now we can use the dal object, so let's print
        // out some rows from the Meal table, in the MealPlanningDatabase.
        // We need to pass the dal method everything it needs to run a query, including
        // the database name, the query, and the user's sql credentials.
        // Check the connections
        if (mealPlanningConnection != null) {
            System.out.println("Successfully connected to the MealPlanning database.");
        } else {
            System.out.println("Failed to connect to the MealPlanning database.");
        }

        if (arcadeGamesConnection != null) {
            System.out.println("Successfully connected to the ArcadeGames database.");
        } else {
            System.out.println("Failed to connect to the ArcadeGames database.");
        }

        if (videoGameSystemsConnection != null) {
            System.out.println("Successfully connected to the VideoGameSystems database.");
        } else {
            System.out.println("Failed to connect to the VideoGameSystems database.");
        }
    }
}