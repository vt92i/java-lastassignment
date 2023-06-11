package Control;

import DAO.UserDAO;
import Model.User;

import java.util.List;

public class UserControl {
  private static UserDAO userDAO = null;

  public UserControl() {
    if (userDAO == null)
      userDAO = new UserDAO();
  }

  public void insertUser(User user) {
    userDAO.insertUser(user);
  }

  public void updateUser(User user) {
    userDAO.updateUser(user);
  }

  public List<User> searchUsers(String keyword) {
    return userDAO.searchUsers(keyword);
  }
  
  public void deleteUser(int userId) {
    userDAO.deleteUser(userId);
  }
}
