package main.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usr")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "user_name", unique = true)
  private String username;

  @Column(name = "password")
  private String password;

  public User() {
  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
