package Table;

import Model.Role;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RoleTable extends AbstractTableModel {
  private final List<Role> roles;

  public RoleTable(List<Role> roles) {
    this.roles = roles;
  }


  @Override
  public int getRowCount() {
    return roles.size();
  }

  @Override
  public int getColumnCount() {
    return 1;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return switch (columnIndex) {
      case 0 -> "Role";
      default -> null;
    };
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return switch (columnIndex) {
      case 0 -> roles.get(rowIndex).getName();
      case 1 -> roles.get(rowIndex).getId();
      default -> null;
    };
  }
}
