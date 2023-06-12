package Table;

import Model.Book;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTable extends AbstractTableModel {
  private final List<Book> books;

  public BookTable(List<Book> books) {
    this.books = books;
  }

  @Override
  public int getRowCount() {
    return books.size();
  }

  @Override
  public int getColumnCount() {
    return 7;
  }

  @Override
  public String getColumnName(int columnIndex) {
    switch (columnIndex) {
      case 0:
        return "ISBN";
      case 1:
        return "Title";
      case 2:
        return "Author";
      case 3:
        return "Publisher";
      case 4:
        return "Year";
      case 5:
        return "Quantity";
      case 6:
        return "Genre";
      default:
        return null;
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return books.get(rowIndex).getIsbn();
      case 1:
        return books.get(rowIndex).getTitle();
      case 2:
        return books.get(rowIndex).getAuthor();
      case 3:
        return books.get(rowIndex).getPublisher();
      case 4:
        return books.get(rowIndex).getYear();
      case 5:
        return books.get(rowIndex).getQuantity();
      case 6:
        return books.get(rowIndex).getGenre().getName();
      default:
        return null;
    }
  }
}
