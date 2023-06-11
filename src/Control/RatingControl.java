package Control;

import DAO.RatingDAO;
import Model.Rating;

import java.util.List;

public class RatingControl {
  private static RatingDAO ratingDAO = null;

  public RatingControl() {
    if (ratingDAO == null)
      ratingDAO = new RatingDAO();
  }

  public void insertRating(Rating rating) {
    ratingDAO.insertRating(rating);
  }

  public void updateRating(Rating rating) {
    ratingDAO.updateRating(rating);
  }

  public List<Rating> searchRatings(String keyword) {
    return ratingDAO.searchRatings(keyword);
  }

  public void deleteRating(int ratingId) {
    ratingDAO.deleteRating(ratingId);
  }
}
