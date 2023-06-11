package DAO;

import DB.DBConnector;
import Model.Role;
import Model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
  private static DBConnector dbConnector;

  public UserDAO() {
    if (dbConnector == null)
      dbConnector = new DBConnector();
  }

  public void insertUser(User user) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password, name, age, role) VALUES (?, ?, ?, ?, ?)")) {
      preparedStatement.setString(1, user.getUsername());
      preparedStatement.setString(2, user.getPassword());
      preparedStatement.setString(3, user.getName());
      preparedStatement.setInt(4, user.getAge());
      preparedStatement.setInt(5, user.getRole().getId());

      preparedStatement.executeUpdate();

      System.out.println("User inserted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to insert user.");
      e.printStackTrace();
    }
  }

  public void updateUser(User user) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE users SET username = ?, password = ?, name = ?, age = ?, role = ? WHERE id = ?")) {
      preparedStatement.setString(1, user.getUsername());
      preparedStatement.setString(2, user.getPassword());
      preparedStatement.setString(3, user.getName());
      preparedStatement.setInt(4, user.getAge());
      preparedStatement.setInt(5, user.getRole().getId());
      preparedStatement.setInt(6, user.getId());

      preparedStatement.executeUpdate();

      System.out.println("User updated successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to update user.");
      e.printStackTrace();
    }
  }

  public List<User> searchUsers(String keyword) {
    List<User> users = new ArrayList<>();
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id LIKE ? OR username LIKE ? OR name LIKE ? OR age LIKE ? OR role LIKE ?")) {
      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");
      preparedStatement.setString(3, "%" + keyword + "%");
      preparedStatement.setString(4, "%" + keyword + "%");
      preparedStatement.setString(5, "%" + keyword + "%");


      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        int roleId = resultSet.getInt("role");

        RoleDAO roleDAO = new RoleDAO();
        Role role = roleDAO.searchRoles(String.valueOf(roleId)).get(0);

        User user = new User(id, username, password, name, age, role);
        users.add(user);
      }
    } catch (SQLException e) {
      System.out.println("Failed to search users.");
      e.printStackTrace();
    }

    return users;
  }

  public void deleteUser(int userId) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM users WHERE id = ?")) {
      preparedStatement.setInt(1, userId);

      preparedStatement.executeUpdate();

      System.out.println("User deleted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to delete user.");
      e.printStackTrace();
    }
  }
}
