package Model;

import java.util.Date;

public class Borrowing {
  private final Book book;
  private final User user;
  private final Date dateBorrowed;
  private final Date dateReturned;
  private final double fineAmount;
  private int id;

  public Borrowing(Book book, User user, Date dateBorrowed, Date dateReturned, double fineAmount) {
    this.book = book;
    this.user = user;
    this.dateBorrowed = dateBorrowed;
    this.dateReturned = dateReturned;
    this.fineAmount = fineAmount;
  }

  public Borrowing(int id, Book book, User user, Date dateBorrowed, Date dateReturned, double fineAmount) {
    this.id = id;
    this.book = book;
    this.user = user;
    this.dateBorrowed = dateBorrowed;
    this.dateReturned = dateReturned;
    this.fineAmount = fineAmount;
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

  public Date getDateBorrowed() {
    return dateBorrowed;
  }

  public Date getDateReturned() {
    return dateReturned;
  }

  public double getFineAmount() {
    return fineAmount;
  }
}
