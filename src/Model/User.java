package Model;

public class User {
  private final String username;
  private final String password;
  private final String name;
  private final int age;
  private final Role role;
  private int id;

  public User(String username, String password, String name, int age, Role role) {
    this.username = username;
    this.password = password;
    this.name = name;
    this.age = age;
    this.role = role;
  }

  public User(int id, String username, String password, String name, int age, Role role) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.name = name;
    this.age = age;
    this.role = role;
  }

  public int getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public Role getRole() {
    return role;
  }
}
