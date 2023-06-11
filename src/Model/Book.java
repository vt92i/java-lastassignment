package Model;

public class Book {
  private final String isbn;
  private final String title;
  private final String author;
  private final String publisher;
  private final int year;
  private final int quantity;
  private final Genre genre;
  private int id;

  public Book(String isbn, String title, String author, String publisher, int year, int quantity, Genre genre) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.year = year;
    this.quantity = quantity;
    this.genre = genre;
  }

  public Book(int id, String isbn, String title, String author, String publisher, int year, int quantity, Genre genre) {
    this.isbn = isbn;
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.year = year;
    this.quantity = quantity;
    this.genre = genre;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getIsbn() {
    return isbn;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getPublisher() {
    return publisher;
  }

  public int getYear() {
    return year;
  }

  public int getQuantity() {
    return quantity;
  }

  public Genre getGenre() {
    return genre;
  }
}
