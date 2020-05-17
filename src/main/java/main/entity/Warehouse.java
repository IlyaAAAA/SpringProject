package main.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "warehouses")
public class Warehouse {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false, unique = true)
  private String name;

  private Integer quantity;

  private Integer amount;

  public Warehouse(String name, Integer quantity, Integer amount) {
    this.name = name;
    this.quantity = quantity;
    this.amount = amount;
  }
}
