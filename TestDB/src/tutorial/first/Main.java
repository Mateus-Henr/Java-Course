package tutorial.first;

import java.sql.*;

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
            // Depending on the database that you using you've got to commit the changes, with SQLite it happens as soon
            // as we "execute" the statement.
            // The default behaviour of Connection objects is to auto commit any changes
//            conn.setAutoCommit(false);

            // Statement Objects
            // They are used when we want to make SQL statements and execute them on the database.
            // Creating a statement instance by calling the Connection method. So the statement can only be run against
            // a database that we connect to.
            Statement statement = conn.createStatement();
            // Using the "IF NOT EXISTS" to create the table only if it doesn't exist.
            statement.execute("CREATE TABLE IF NOT EXISTS contacts (name TEXT, phone INTEGER, email TEXT)");

            // CREATE
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                      "VALUES('Joe', 4567, 'joe@anywhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                      "VALUES('Jane', 546565, 'jane@somewhere.com')");
//            statement.execute("INSERT INTO contacts (name, phone, email)" +
//                                      "VALUES('Fido', 65763, 'dog@anywhere.com')");

            // UPDATE and DELETE
            // Always remember the "WHERE" clause with "UPDATE" and "DELETE", otherwise all of your data will be
            // modified.
//            statement.execute("UPDATE contacts SET phone=5566789 WHERE name='Jane'");
//            statement.execute("DELETE FROM contacts WHERE name='Joe'");

            // The "execute()" method returns a boolean that will be true if the statement that we are executing
            // returns an instance of the "ResultSet" class and false if it returns no results. It also returns false
            // if we are using an "UPDATE" statement and this statement usually returns the number of records that
            // have been updated.
            // When querying the database (using "SELECT"), it returns the records that match the query as a "ResultSet"
            // instance, and we can get these results by calling the ".getResultSet()" method.
            statement.execute("SELECT * FROM contacts");
            ResultSet results = statement.getResultSet();

            // Every Statement object has a cursor.
            // If you reuse a statement object to do a query, then any ResultSet associated with that Statement object
            // is closed and a new one is created for the new query. So if we want to work with multiple queries at the
            // same time, it's imperative to use a different Statement instance for each query. It's only okay to use
            // the same instance when we are doing "UPDATE", "DELETE" or "CREATE", since we weren't checking the
            // results.
            // We can only use the same Statement object if we wait for it to finish a query to execute another, since
            // they can only have one ResultSet associate with it.
            // When a ResultSet is created its cursor is placed before the first record and the first time we call
            // "results.next()" the cursor will be moved to the first record, and it goes on (until it returns false).
            // And the "get()" methods are values returned from where the cursor currently is.
            while (results.next())
            {
                // Calling specific "get" methods based on the type of data.
                System.out.println(results.getString("name") + " " +
                                           results.getInt("phone") + " " +
                                           results.getString("email"));
            }

            // We have to close it before we close the Statement instance since it's associated to that.
            results.close();

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