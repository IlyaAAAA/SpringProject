package main.entity;

import javax.persistence.*;
import java.sql.Timestamp;

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

  public Sale() {

  }

  public Sale(Integer amount, Integer quantity, Timestamp saleDate) {
    this.amount = amount;
    this.quantity = quantity;
    this.saleDate = saleDate;
  }

  @ManyToOne
  @JoinColumn(name = "warehouse_id")
  private Warehouse warehouse;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Timestamp getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(Timestamp saleDate) {
    this.saleDate = saleDate;
  }

  @Override
  public String toString() {
    return "Sale{" +
            "id=" + id +
            ", amount=" + amount +
            ", quantity=" + quantity +
            ", saleDate=" + saleDate +
            '}';
  }
}
