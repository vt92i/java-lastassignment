package Table;

import Model.Wishlist;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class WishlistTable extends AbstractTableModel {
  private final List<Wishlist> wishlists;

  public WishlistTable(List<Wishlist> wishlists) {
    this.wishlists = wishlists;
  }


  @Override
  public int getRowCount() {
    return wishlists.size();
  }

  @Override
  public int getColumnCount() {
    return 2;
  }

  @Override
  public String getColumnName(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return "User";
      case 1:
        return "Book";
      default:
        return null;
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return wishlists.get(rowIndex).getUser().getName();
      case 1:
        return wishlists.get(rowIndex).getBook().getTitle();
      case 2:
        return wishlists.get(rowIndex).getId();
      default:
        return null;
    }
  }
}
