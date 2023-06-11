package Model;

public class Role {
  private final String name;
  private int id;

  public Role(String name) {
    this.name = name;
  }

  public Role(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
