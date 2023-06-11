package Control;

import DAO.WishlistDAO;
import Model.Wishlist;

import java.util.List;

public class WishlistControl {
  private static WishlistDAO wishlistDAO = null;

  public WishlistControl() {
    if (wishlistDAO == null)
      wishlistDAO = new WishlistDAO();
  }

  public void insertWishlist(Wishlist wishlist) {
    wishlistDAO.insertWishlist(wishlist);
  }

  public void updateWishlist(Wishlist wishlist) {
    wishlistDAO.updateWishlist(wishlist);
  }

  public List<Wishlist> searchWishlists(String keyword) {
    return wishlistDAO.searchWishlists(keyword);
  }

  public void deleteWishlist(int wishlistId) {
    wishlistDAO.deleteWishlist(wishlistId);
  }
}
