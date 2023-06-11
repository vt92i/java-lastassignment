package DAO;

import DB.DBConnector;
import Model.Book;
import Model.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
  private final DBConnector dbConnector;

  public BookDAO() {
    dbConnector = new DBConnector();
  }

  public void insertBook(Book book) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO books (isbn, title, author, publisher, year, quantity, genre_id) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
      preparedStatement.setString(1, book.getIsbn());
      preparedStatement.setString(2, book.getTitle());
      preparedStatement.setString(3, book.getAuthor());
      preparedStatement.setString(4, book.getPublisher());
      preparedStatement.setInt(5, book.getYear());
      preparedStatement.setInt(6, book.getQuantity());
      preparedStatement.setInt(7, book.getGenre().getId());

      preparedStatement.executeUpdate();

      System.out.println("Book inserted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to insert book.");
      e.printStackTrace();
    }
  }

  public void updateBook(Book book) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE books SET title = ?, author = ?, publisher = ?, year = ?, quantity = ?, genre_id = ? WHERE isbn = ?")) {
      preparedStatement.setString(1, book.getTitle());
      preparedStatement.setString(2, book.getAuthor());
      preparedStatement.setString(3, book.getPublisher());
      preparedStatement.setInt(4, book.getYear());
      preparedStatement.setInt(5, book.getQuantity());
      preparedStatement.setInt(6, book.getGenre().getId());
      preparedStatement.setString(7, book.getIsbn());

      preparedStatement.executeUpdate();

      System.out.println("Book updated successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to update book.");
      e.printStackTrace();
    }
  }

  public List<Book> searchBooks(String keyword) {
    List<Book> books = new ArrayList<>();
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM books WHERE isbn LIKE ? OR title LIKE ? OR author LIKE ? OR publisher LIKE ? OR year LIKE ?")) {
      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");
      preparedStatement.setString(3, "%" + keyword + "%");
      preparedStatement.setString(4, "%" + keyword + "%");
      preparedStatement.setString(5, "%" + keyword + "%");

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        String isbn = resultSet.getString("isbn");
        String title = resultSet.getString("title");
        String author = resultSet.getString("author");
        String publisher = resultSet.getString("publisher");
        int year = resultSet.getInt("year");
        int quantity = resultSet.getInt("quantity");
        int genreId = resultSet.getInt("genre_id");

        Genre genre = new GenreDAO().searchGenres(String.valueOf(genreId)).get(0);

        books.add(new Book(isbn, title, author, publisher, year, quantity, genre));
        Book book = new Book(isbn, title, author, publisher, year, quantity, genre);
        books.add(book);
      }
    } catch (SQLException e) {
      System.out.println("Failed to search books.");
      e.printStackTrace();
    }

    return books;
  }

  public void deleteBook(String isbn) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM books WHERE isbn = ?")) {
      preparedStatement.setString(1, isbn);

      preparedStatement.executeUpdate();

      System.out.println("Book deleted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to delete book.");
      e.printStackTrace();
    }
  }
}
