package Table;

import Model.User;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class UserTable extends AbstractTableModel {
  private final List<User> users;

  public UserTable(List<User> users) {
    this.users = users;
  }


  @Override
  public int getRowCount() {
    return users.size();
  }

  @Override
  public int getColumnCount() {
    return 5;
  }

  @Override
  public String getColumnName(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return "Name";
      case 1:
        return "Username";
      case 2:
        return "Password";
      case 3:
        return "Role";
      case 4:
        return "Age";
      default:
        return null;
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return users.get(rowIndex).getName();
      case 1:
        return users.get(rowIndex).getUsername();
      case 2:
        return users.get(rowIndex).getPassword();
      case 3:
        return users.get(rowIndex).getRole().getName();
      case 4:
        return users.get(rowIndex).getAge();
      case 5:
        return users.get(rowIndex).getId();
      default:
        return null;
    }
  }
}
