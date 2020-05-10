package main.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "expense_items")
public class ExpenseItem {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(nullable = false)
  private String name;

}
