package Control;

import DAO.GenreDAO;
import Model.Genre;

import java.util.List;

public class GenreControl {
  private static GenreDAO genreDAO = null;

  public GenreControl() {
    if (genreDAO == null)
      genreDAO = new GenreDAO();
  }

  public void insertGenre(Genre genre) {
    genreDAO.insertGenre(genre);
  }

  public void updateGenre(Genre genre) {
    genreDAO.updateGenre(genre);
  }

  public List<Genre> searchGenres(String keyword) {
    return genreDAO.searchGenres(keyword);
  }

  public void deleteGenre(int genreId) {
    genreDAO.deleteGenre(genreId);
  }

}
