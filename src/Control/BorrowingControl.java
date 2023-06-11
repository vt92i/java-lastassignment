package Control;

import DAO.BorrowingDAO;
import Model.Borrowing;

import java.util.List;

public class BorrowingControl {
  private static BorrowingDAO borrowingDAO = null;

  public BorrowingControl() {
    if (borrowingDAO == null)
      borrowingDAO = new BorrowingDAO();
  }

  public void insertBorrowing(Borrowing borrowing) {
    borrowingDAO.insertBorrowing(borrowing);
  }

  public void updateBorrowing(Borrowing borrowing) {
    borrowingDAO.updateBorrowing(borrowing);
  }

  public List<Borrowing> searchBorrowings(String keyword) {
    return borrowingDAO.searchBorrowings(keyword);
  }

  public void deleteBorrowing(int borrowingId) {
    borrowingDAO.deleteBorrowing(borrowingId);
  }

}
