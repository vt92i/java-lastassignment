package DAO;

import DB.DBConnector;
import Model.Book;
import Model.Rating;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO {
  private final DBConnector dbConnector;

  public RatingDAO() {
    dbConnector = new DBConnector();
  }

  public void insertRating(Rating rating) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ratings (book_isbn, user_id, rating, comment) VALUES (?, ?, ?, ?)")) {
      preparedStatement.setString(1, rating.getBook().getIsbn());
      preparedStatement.setInt(2, rating.getUser().getId());
      preparedStatement.setDouble(3, rating.getRating());
      preparedStatement.setString(4, rating.getComment());

      preparedStatement.executeUpdate();

      System.out.println("Rating inserted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to insert rating.");
      e.printStackTrace();
    }
  }

  public void updateRating(Rating rating) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE ratings SET rating = ?, comment = ? WHERE id = ?")) {
      preparedStatement.setDouble(1, rating.getRating());
      preparedStatement.setString(2, rating.getComment());
      preparedStatement.setInt(3, rating.getId());

      preparedStatement.executeUpdate();

      System.out.println("Rating updated successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to update rating.");
      e.printStackTrace();
    }
  }

  public List<Rating> searchRatings(String keyword) {
    List<Rating> ratings = new ArrayList<>();
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ratings WHERE id LIKE ? OR book_isbn LIKE ? OR user_id LIKE ? OR rating LIKE ? OR comment LIKE ?")) {
      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");
      preparedStatement.setString(3, "%" + keyword + "%");
      preparedStatement.setString(4, "%" + keyword + "%");
      preparedStatement.setString(5, "%" + keyword + "%");

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String bookIsbn = resultSet.getString("book_isbn");
        int userId = resultSet.getInt("user_id");
        double ratingValue = resultSet.getDouble("rating");
        String comment = resultSet.getString("comment");

        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.searchBooks(bookIsbn).get(0); // TODO: Fix this (searchBooks returns a list of books, but we only need one

        UserDAO userDAO = new UserDAO();
        User user = userDAO.searchUsers(String.valueOf(userId)).get(0); // TODO: Fix this (searchUsers returns a list of users, but we only need one

        Rating rating = new Rating(id, book, user, ratingValue, comment);
        ratings.add(rating);
      }
    } catch (SQLException e) {
      System.out.println("Failed to search ratings.");
      e.printStackTrace();
    }

    return ratings;
  }

  public void deleteRating(int ratingId) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM ratings WHERE id = ?")) {
      preparedStatement.setInt(1, ratingId);

      preparedStatement.executeUpdate();

      System.out.println("Rating deleted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to delete rating.");
      e.printStackTrace();
    }
  }
}
