package Control;

import DAO.BookDAO;
import Model.Book;

import java.util.List;

public class BookControl {
  private static BookDAO bookDAO = null;

  public BookControl() {
    if (bookDAO == null)
      bookDAO = new BookDAO();
  }

  public void insertBook(Book book) {
    bookDAO.insertBook(book);
  }

  public void updateBook(Book book) {
    bookDAO.updateBook(book);
  }

  public List<Book> searchBooks(String keyword) {
    return bookDAO.searchBooks(keyword);
  }

  public void deleteBook(String isbn) {
    bookDAO.deleteBook(isbn);
  }

}
