package main.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDate;

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

  @Column(name = "sale_date")
  private LocalDate saleDate;

  @ManyToOne
  @JoinColumn(name = "warehouse_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Warehouse warehouse;

  public Sale(Integer amount, Integer quantity, LocalDate saleDate, Warehouse warehouse) {
    this.amount = amount;
    this.quantity = quantity;
    this.saleDate = saleDate;
    this.warehouse = warehouse;

  }
}
