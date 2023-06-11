package Model;

public class Genre {
  private final String name;
  private int id;

  public Genre(String name) {
    this.name = name;
  }

  public Genre(int id, String name) {
    this.name = name;
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
