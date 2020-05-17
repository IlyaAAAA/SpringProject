package main.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
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

  public Charge(Integer amount, Timestamp chargeDate, ExpenseItem expenseItem) {
    this.amount = amount;
    this.chargeDate = chargeDate;
    this.expenseItem = expenseItem;
  }
}
