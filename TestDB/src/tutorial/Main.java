package tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main
{
    public static void main(String[] args)
    {
        // Creating a database
        // When using SQLite connecting to database that doesn't exist will create a new one.
        // A connection string is used to connect to a database, and it may vary depending on the database being used.
        // In this connection string you can also specify database attributes.
        try
        {
            // Setting up the place where the db file will be.
//            Class.forName("org.sql.JDBC"); // This needs to be used for older versions of JDBC.
            Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\JavaCourse\\TestDB\\testjava.db");

            // Statement Objects
            // They are used when we want to make SQL statements and execute them on the database.
            // Creating a statement instance by calling the Connection method. So the statement can only be run against
            // a database that we connect to.
            Statement statement = conn.createStatement();
            statement.execute("CREATE TABLE contacts (name TEXT, phone INTEGER, email TEXT)");

            // It's important to close the resources after using them, since apps have a limited number of resources.
            // We could also have used "try-with-resources" for this. If using it you would need to put within the
            // parenthesis, the Connection and the Statement. AND THE ORDERING HERE IS IMPORTANT.
            // If we close the Connection first we will get an exception, since the Statements are associated to a
            // Connection.
            statement.close();
            conn.close();
        }
        catch (SQLException e)
        {
            System.out.println("Something went wrong: " + e.getMessage());
        }

    }

}

// Using a database from a Java application
//
// We use the JDBC (Java DataBase Connectivity) for this purpose. It's also used to work with spreadsheets and flat files.
// It acts as a middleman between a Java application and a data source. To use a particular data source from an
// application, we need the JDBC driver for the data source. For example, to access a SQLite database from an app,
// we need a SQLite JDBC driver.
//
// The driver
// It's simply a Java library containing classes that implement the JDBC API and since all divers have to implement the
// same interfaces changing the data source is not that complicated. But it depends on the SQL code.
// The JDBC driver has to be written in Java, but it can consist of a thin Java layer that calls code written in other
// languages. If you're feeling adventurous you can try to make your own driver.
//
// JDBC packages
// It consists of two packages:
// java.sql (core JDBC) - Required when working with database servers.
// java.sql (optional JDBC).
//
// Built-in databases (JDK)
// All the popular databases provide JDBC drives. In the JDK there's a database called derby that's used for desktop
// apps, or when prototyping. And its driver comes with the JDK.
// In the case of SQLite, its driver already comes with it.
//
// Downloading the SQLite driver
// Go to "https://github.com/xerial/sqlite-jdbc/releases" and download the latest version.
//
// Downloading the DB Browser
// "https://download.sqlitebrowser.org/DB.Browser.for.SQLite-3.12.2-win64.msi" to download.
//
// OBS: If you are using the Db Browser to make changes to the database, it usually locks the database, so you need to
// close the connection with the database to free the lock.
//
// Adding SQLite driver to the project
// You can find the ".jar" file in the "bin" folder, just add it to the "Library" of the project, you can select
// "Classes".