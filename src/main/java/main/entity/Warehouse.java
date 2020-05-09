package main.entity;

import javax.persistence.*;

@Entity
@Table(name = "warehouses")
public class Warehouse {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

  private Integer quantity;

  private Integer amount;

  public Warehouse() {

  }

  public Warehouse(String name, Integer quantity, Integer amount) {
    this.name = name;
    this.quantity = quantity;
    this.amount = amount;
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

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Warehouse{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", quantity=" + quantity +
            ", amount=" + amount +
            '}';
  }
}
