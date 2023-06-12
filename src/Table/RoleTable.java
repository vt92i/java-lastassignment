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
    if (columnIndex == 0) {
      return "Role";
    }
    return null;
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return roles.get(rowIndex).getName();
      case 1:
        return roles.get(rowIndex).getId();
      default:
        return null;
    }
  }
}
