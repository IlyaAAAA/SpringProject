package main.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "charges")
public class Charge {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer amount;

  @Column(name = "charge_date")
  private LocalDate chargeDate;

  @ManyToOne
  @JoinColumn(name = "expense_item_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private ExpenseItem expenseItem;

  public Charge(Integer amount, LocalDate chargeDate, ExpenseItem expenseItem) {
    this.amount = amount;
    this.chargeDate = chargeDate;
    this.expenseItem = expenseItem;
  }
}
