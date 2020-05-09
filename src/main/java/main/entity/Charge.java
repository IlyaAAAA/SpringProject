package main.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "charges")
public class Charge {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer amount;

  @Column(name = "charge_date", nullable = false)
  private Timestamp chargeDate;

  @ManyToOne
  @JoinColumn(name = "expense_item_id")
  private ExpenseItem expenseItem;

  public Charge() {

  }

  public Charge(Integer amount, Timestamp chargeDate) {
    this.id = id;
    this.amount = amount;
    this.chargeDate = chargeDate;
  }

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

  public Timestamp getChargeDate() {
    return chargeDate;
  }

  public void setChargeDate(Timestamp chargeDate) {
    this.chargeDate = chargeDate;
  }




  @Override
  public String toString() {
    return "Charge{" +
            "id=" + id +
            ", amount=" + amount +
            ", chargeDate=" + chargeDate +
            '}';
  }
}
