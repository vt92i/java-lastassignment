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
    return switch (columnIndex) {
      case 0 -> "Name";
      case 1 -> "Username";
      case 2 -> "Password";
      case 3 -> "Role";
      case 4 -> "Age";
      default -> null;
    };
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return switch (columnIndex) {
      case 0 -> users.get(rowIndex).getName();
      case 1 -> users.get(rowIndex).getUsername();
      case 2 -> users.get(rowIndex).getPassword();
      case 3 -> users.get(rowIndex).getRole().getName();
      case 4 -> users.get(rowIndex).getAge();
      case 5 -> users.get(rowIndex).getId();
      default -> null;
    };
  }
}
