package Table;

import Model.Borrowing;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BorrowingTable extends AbstractTableModel {
  private final List<Borrowing> borrowings;

  public BorrowingTable(List<Borrowing> borrowings) {
    this.borrowings = borrowings;
  }

  @Override
  public int getRowCount() {
    return borrowings.size();
  }

  @Override
  public int getColumnCount() {
    return 5;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return switch (columnIndex) {
      case 0 -> "Book";
      case 1 -> "User";
      case 2 -> "Date Borrowed";
      case 3 -> "Date Returned";
      case 4 -> "Fine Amount";
      default -> null;
    };
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return switch (columnIndex) {
      case 0 -> borrowings.get(rowIndex).getBook().getTitle();
      case 1 -> borrowings.get(rowIndex).getUser().getName();
      case 2 -> borrowings.get(rowIndex).getDateBorrowed();
      case 3 -> borrowings.get(rowIndex).getDateReturned();
      case 4 -> borrowings.get(rowIndex).getFineAmount();
      case 5 -> borrowings.get(rowIndex).getId();
      default -> null;
    };
  }
}
