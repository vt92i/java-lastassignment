package DAO;

import DB.DBConnector;
import Model.Book;
import Model.Borrowing;
import Model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowingDAO {
  private static DBConnector dbConnector = null;

  public BorrowingDAO() {
    if (dbConnector == null)
      dbConnector = new DBConnector();
  }

  public void insertBorrowing(Borrowing borrowing) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO borrowings (id, book_isbn, user_id, date_borrowed, date_returned, fine_amount) VALUES (?, ?, ?, ?, ?, ?)")) {
      preparedStatement.setInt(1, borrowing.getId());
      preparedStatement.setString(2, borrowing.getBook().getIsbn());
      preparedStatement.setInt(3, borrowing.getUser().getId());
      preparedStatement.setDate(4, Date.valueOf(borrowing.getDateBorrowed().toString()));
      preparedStatement.setDate(5, Date.valueOf(borrowing.getDateReturned().toString()));
      preparedStatement.setDouble(6, borrowing.getFineAmount());

      preparedStatement.executeUpdate();

      System.out.println("Borrowing inserted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to insert borrowing.");
      e.printStackTrace();
    }
  }

  public void updateBorrowing(Borrowing borrowing) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE borrowings SET book_isbn = ?, user_id = ?, date_borrowed = ?, date_returned = ?, fine_amount = ? WHERE id = ?")) {
      preparedStatement.setString(1, borrowing.getBook().getIsbn());
      preparedStatement.setInt(2, borrowing.getUser().getId());
      preparedStatement.setDate(3, Date.valueOf(borrowing.getDateBorrowed().toString()));
      preparedStatement.setDate(4, Date.valueOf(borrowing.getDateReturned().toString()));
      preparedStatement.setDouble(5, borrowing.getFineAmount());
      preparedStatement.setInt(6, borrowing.getId());

      preparedStatement.executeUpdate();

      System.out.println("Borrowing updated successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to update borrowing.");
      e.printStackTrace();
    }
  }

  public List<Borrowing> searchBorrowings(String keyword) {
    List<Borrowing> borrowings = new ArrayList<>();
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM borrowings WHERE book_isbn LIKE ? OR user_id LIKE ?")) {
      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String bookIsbn = resultSet.getString("book_isbn");
        int userId = resultSet.getInt("user_id");
        Date dateBorrowed = resultSet.getDate("date_borrowed");
        Date dateReturned = resultSet.getDate("date_returned");
        double fineAmount = resultSet.getDouble("fine_amount");

        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.searchBooks(bookIsbn).get(0);

        UserDAO userDAO = new UserDAO();
        User user = userDAO.searchUsers(String.valueOf(userId)).get(0);

        Borrowing borrowing = new Borrowing(id, book, user, dateBorrowed, dateReturned, fineAmount);
        borrowings.add(borrowing);
      }
    } catch (SQLException e) {
      System.out.println("Failed to search borrowings.");
      e.printStackTrace();
    }

    return borrowings;
  }

  public void deleteBorrowing(int borrowingId) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM borrowings WHERE id = ?")) {
      preparedStatement.setInt(1, borrowingId);

      preparedStatement.executeUpdate();

      System.out.println("Borrowing deleted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to delete borrowing.");
      e.printStackTrace();
    }
  }
}
