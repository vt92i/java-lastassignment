package DAO;

import DB.DBConnector;
import Model.Role;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO {
  private final DBConnector dbConnector;

  public RoleDAO() {
    dbConnector = new DBConnector();
  }

  public void insertRole(Role role) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO roles (name) VALUES (?)")) {
      preparedStatement.setString(1, role.getName());

      preparedStatement.executeUpdate();

      System.out.println("Role inserted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to insert role.");
      e.printStackTrace();
    }
  }

  public void updateRole(Role role) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("UPDATE roles SET name = ? WHERE id = ?")) {
      preparedStatement.setString(1, role.getName());
      preparedStatement.setInt(2, role.getId());

      preparedStatement.executeUpdate();

      System.out.println("Role updated successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to update role.");
      e.printStackTrace();
    }
  }

  public List<Role> searchRoles(String keyword) {
    List<Role> roles = new ArrayList<>();
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM roles WHERE id LIKE ? OR name LIKE ?")) {
      preparedStatement.setString(1, "%" + keyword + "%");
      preparedStatement.setString(2, "%" + keyword + "%");

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");

        Role role = new Role(id, name);
        roles.add(role);
      }
    } catch (SQLException e) {
      System.out.println("Failed to search roles.");
      e.printStackTrace();
    }

    return roles;
  }

  public void deleteRole(int roleId) {
    try (Connection connection = dbConnector.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM roles WHERE id = ?")) {
      preparedStatement.setInt(1, roleId);

      preparedStatement.executeUpdate();

      System.out.println("Role deleted successfully.");
    } catch (SQLException e) {
      System.out.println("Failed to delete role.");
      e.printStackTrace();
    }
  }
}
