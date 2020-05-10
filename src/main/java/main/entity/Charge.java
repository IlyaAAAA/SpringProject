package main.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
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
}
