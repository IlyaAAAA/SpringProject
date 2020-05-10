package main.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
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

}
