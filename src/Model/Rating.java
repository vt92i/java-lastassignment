package Model;

public class Rating {
  private final Book book;
  private final User user;
  private final double rating;
  private final String comment;
  private int id;

  public Rating(Book book, User user, double rating, String comment) {
    this.book = book;
    this.user = user;
    this.rating = rating;
    this.comment = comment;
  }

  public Rating(int id, Book book, User user, double rating, String comment) {
    this.id = id;
    this.book = book;
    this.user = user;
    this.rating = rating;
    this.comment = comment;
  }

  public int getId() {
    return id;
  }

  public Book getBook() {
    return book;
  }

  public User getUser() {
    return user;
  }

  public double getRating() {
    return rating;
  }

  public String getComment() {
    return comment;
  }
}
