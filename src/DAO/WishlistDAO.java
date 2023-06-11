package DAO;

import DB.DBConnector;
import Model.Book;
import Model.User;
import Model.Wishlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WishlistDAO {
  private final DBConnector dbConnector;

  public WishlistDAO() {
    dbConnector = new DBConnector();
  }

  public void insertWishlist(Wishlist wishlist) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO wishlists (user_id, product_id) VALUES (?, ?)")) {
      preparedStatement.setInt(1, wishlist.getUser().getId());
      preparedStatement.setInt(2, wishlist.getBook().getId());

      preparedStatement.executeUpdate();

      System.out.println("Wishlist inserted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to insert wishlist.");
      e.printStackTrace();
    }
  }

  public void updateWishlist(Wishlist wishlist) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE wishlists SET user_id = ?, product_id = ? WHERE id = ?")) {
      preparedStatement.setInt(1, wishlist.getUser().getId());
      preparedStatement.setInt(2, wishlist.getBook().getId());
      preparedStatement.setInt(3, wishlist.getId());

      preparedStatement.executeUpdate();

      System.out.println("Wishlist updated successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to update wishlist.");
      e.printStackTrace();
    }
  }

  public List<Wishlist> searchWishlists(String keyword) {
    List<Wishlist> wishlists = new ArrayList<>();
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM wishlists WHERE id LIKE ? OR user_id LIKE ? OR book_isbn LIKE ?")) {
      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");
      preparedStatement.setString(3, "%" + keyword + "%");

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        int userId = resultSet.getInt("user_id");
        String bookIsbn = resultSet.getString("book_isbn");

        UserDAO userDAO = new UserDAO();
        User user = userDAO.searchUsers(String.valueOf(userId)).get(0);

        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.searchBooks(bookIsbn).get(0);

        Wishlist wishlist = new Wishlist(id, user, book);
        wishlists.add(wishlist);
      }
    } catch (SQLException e) {
      System.out.println("Failed to search wishlists.");
      e.printStackTrace();
    }

    return wishlists;
  }

  public void deleteWishlist(int wishlistId) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM wishlists WHERE id = ?")) {
      preparedStatement.setInt(1, wishlistId);

      preparedStatement.executeUpdate();

      System.out.println("Wishlist deleted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to delete wishlist.");
      e.printStackTrace();
    }
  }
}
