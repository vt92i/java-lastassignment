package Table;

import Model.Rating;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class RatingTable extends AbstractTableModel {
  private final List<Rating> ratings;

  public RatingTable(List<Rating> ratings) {
    this.ratings = ratings;
  }


  @Override
  public int getRowCount() {
    return ratings.size();
  }

  @Override
  public int getColumnCount() {
    return 4;
  }

  @Override
  public String getColumnName(int columnIndex) {
    return switch (columnIndex) {
      case 0 -> "Book";
      case 1 -> "User";
      case 2 -> "Rating";
      case 3 -> "Comment";
      default -> null;
    };
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    return switch (columnIndex) {
      case 0 -> ratings.get(rowIndex).getBook().getTitle();
      case 1 -> ratings.get(rowIndex).getUser().getName();
      case 2 -> ratings.get(rowIndex).getRating();
      case 3 -> ratings.get(rowIndex).getComment();
      case 4 -> ratings.get(rowIndex).getId();
      default -> null;
    };
  }
}
