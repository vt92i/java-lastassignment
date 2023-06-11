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
    return switch (columnIndex) {
      case 0 -> "User";
      case 1 -> "Book";
      default -> null;
    };
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return switch (columnIndex) {
      case 0 -> wishlists.get(rowIndex).getUser().getName();
      case 1 -> wishlists.get(rowIndex).getBook().getTitle();
      case 2 -> wishlists.get(rowIndex).getId();
      default -> null;
    };
  }
}
