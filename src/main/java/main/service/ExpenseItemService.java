package main.service;

import main.entity.ExpenseItem;

import java.util.List;

public interface ExpenseItemService {
  ExpenseItem findExpenseItem(int id);
  List<ExpenseItem> listExpenseItems();
  void deleteExpenseItem(int id);
  void updateExpenseItem(int id, ExpenseItem newExpenseItem);
  void save(ExpenseItem expenseItem);
}
