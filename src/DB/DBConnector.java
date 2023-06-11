package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
  private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/elibr4ry";
  private static final String DB_USERNAME = "root";
  private static final String DB_PASSWORD = "root";

  private Connection connection;

  public DBConnector() {
    try {
      // Load the MySQL JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      // Establish the database connection
      connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

      System.out.println("Connected to the database.");
    } catch (ClassNotFoundException e) {
      System.out.println("Failed to load MySQL JDBC driver.");
      e.printStackTrace();
    } catch (SQLException e) {
      System.out.println("Failed to connect to the database.");
      e.printStackTrace();
    }
  }

  public Connection getConnection() {
    return connection;
  }

  public void closeConnection() {
    if (connection != null) {
      try {
        connection.close();
        System.out.println("Disconnected from the database.");
      } catch (SQLException e) {
        System.out.println("Failed to close the database connection.");
        e.printStackTrace();
      }
    }
  }
}
