package Control;

import DAO.RoleDAO;
import Model.Role;

import java.util.List;

public class RoleControl {
  private static RoleDAO roleDAO = null;

  public RoleControl() {
    if (roleDAO == null)
      roleDAO = new RoleDAO();
  }

  public void insertRole(Role role) {
    roleDAO.insertRole(role);
  }

  public void updateRole(Role role) {
    roleDAO.updateRole(role);
  }

  public List<Role> searchRoles(String keyword) {
    return roleDAO.searchRoles(keyword);
  }

  public void deleteRole(int roleId) {
    roleDAO.deleteRole(roleId);
  }

}
