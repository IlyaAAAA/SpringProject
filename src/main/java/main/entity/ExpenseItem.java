package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "expense_items")
public class ExpenseItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

  public ExpenseItem() {

  }

  public ExpenseItem(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "ExpenseItem{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
