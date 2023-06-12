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
    switch (columnIndex) {
      case 0:
        return "Book";
      case 1:
        return "User";
      case 2:
        return "Date Borrowed";
      case 3:
        return "Date Returned";
      case 4:
        return "Fine Amount";
      default:
        return null;
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return borrowings.get(rowIndex).getBook().getTitle();
      case 1:
        return borrowings.get(rowIndex).getUser().getName();
      case 2:
        return borrowings.get(rowIndex).getDateBorrowed();
      case 3:
        return borrowings.get(rowIndex).getDateReturned();
      case 4:
        return borrowings.get(rowIndex).getFineAmount();
      case 5:
        return borrowings.get(rowIndex).getId();
      default:
        return null;
    }
  }
}
