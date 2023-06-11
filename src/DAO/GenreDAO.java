package DAO;

import DB.DBConnector;
import Model.Genre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenreDAO {
  private final DBConnector dbConnector;

  public GenreDAO() {
    dbConnector = new DBConnector();
  }

  public void insertGenre(Genre genre) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO genres (id, name) VALUES (?, ?)")) {
      preparedStatement.setInt(1, genre.getId());
      preparedStatement.setString(2, genre.getName());

      preparedStatement.executeUpdate();

      System.out.println("Genre inserted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to insert genre.");
      e.printStackTrace();
    }
  }

  public void updateGenre(Genre genre) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE genres SET name = ? WHERE id = ?")) {
      preparedStatement.setString(1, genre.getName());
      preparedStatement.setInt(2, genre.getId());

      preparedStatement.executeUpdate();

      System.out.println("Genre updated successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to update genre.");
      e.printStackTrace();
    }
  }

  public List<Genre> searchGenres(String keyword) {
    List<Genre> genres = new ArrayList<>();
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM genres WHERE id LIKE ? OR name LIKE ?")) {
      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        Genre genre = new Genre(id, name);
        genres.add(genre);
      }
    } catch (SQLException e) {
      System.out.println("Failed to search genres.");
      e.printStackTrace();
    }

    return genres;
  }

  public void deleteGenre(int genreId) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM genres WHERE id = ?")) {
      preparedStatement.setInt(1, genreId);

      preparedStatement.executeUpdate();

      System.out.println("Genre deleted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to delete genre.");
      e.printStackTrace();
    }
  }
}
