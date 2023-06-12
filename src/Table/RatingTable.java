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
    switch (columnIndex) {
      case 0:
        return "Book";
      case 1:
        return "User";
      case 2:
        return "Rating";
      case 3:
        return "Comment";
      default:
        return null;
    }
  }

  @Override
  public Object getValueAt(int rowIndex, int columnIndex) {
    switch (columnIndex) {
      case 0:
        return ratings.get(rowIndex).getBook().getTitle();
      case 1:
        return ratings.get(rowIndex).getUser().getName();
      case 2:
        return ratings.get(rowIndex).getRating();
      case 3:
        return ratings.get(rowIndex).getComment();
      case 4:
        return ratings.get(rowIndex).getId();
      default:
        return null;
    }
  }
}
