package main.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer amount;

  private Integer quantity;

  @Column(name = "sale_date", nullable = false)
  private Timestamp saleDate;

  @ManyToOne
  @JoinColumn(name = "warehouse_id")
  private Warehouse warehouse;

  public Sale(Integer amount, Integer quantity, Timestamp saleDate, Warehouse warehouse) {
    this.amount = amount;
    this.quantity = quantity;
    this.saleDate = saleDate;
    this.warehouse = warehouse;

  }
}
