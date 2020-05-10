package main.entity;

import lombok.Data;

import javax.persistence.*;

@Data
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
}
