package Model;


public class Wishlist {
  private final User user;
  private final Book book;
  private int id;

  public Wishlist(User user, Book book) {
    this.user = user;
    this.book = book;
  }

  public Wishlist(int id, User user, Book book) {
    this.user = user;
    this.book = book;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public User getUser() {
    return user;
  }

  public Book getBook() {
    return book;
  }
}
