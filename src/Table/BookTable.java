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
    return switch (columnIndex) {
      case 0 -> "ISBN";
      case 1 -> "Title";
      case 2 -> "Author";
      case 3 -> "Publisher";
      case 4 -> "Year";
      case 5 -> "Quantity";
      case 6 -> "Genre";
      default -> null;
    };
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return switch (columnIndex) {
      case 0 -> books.get(rowIndex).getIsbn();
      case 1 -> books.get(rowIndex).getTitle();
      case 2 -> books.get(rowIndex).getAuthor();
      case 3 -> books.get(rowIndex).getPublisher();
      case 4 -> books.get(rowIndex).getYear();
      case 5 -> books.get(rowIndex).getQuantity();
      case 6 -> books.get(rowIndex).getGenre().getName();
      default -> null;
    };
  }
}
