package main.service.expenseItemService;

import main.entity.ExpenseItem;

import java.util.List;

public interface ExpenseItemService {
  List<ExpenseItem> getExpenseItemList();
  ExpenseItem save(ExpenseItem expenseItem);
  ExpenseItem update(ExpenseItem expenseItemFromDb, ExpenseItem expenseItem, String field);
  void delete(ExpenseItem expenseItem);
}
