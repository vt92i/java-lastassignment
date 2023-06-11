package Table;

import Model.Genre;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class GenreTable extends AbstractTableModel {
  private final List<Genre> genres;

  public GenreTable(List<Genre> genres) {
    this.genres = genres;
  }


  @Override
  public int getRowCount() {
    return genres.size();
  }

  @Override
  public int getColumnCount() {
    return 1;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return switch (columnIndex) {
      case 0 -> "Genre";
      default -> null;
    };
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return switch (columnIndex) {
      case 0 -> genres.get(rowIndex).getName();
      case 1 -> genres.get(rowIndex).getId();
      default -> null;
    };
  }
}
