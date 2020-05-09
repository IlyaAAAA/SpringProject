package main.service;

import main.entity.ExpenseItem;
import main.exceptions.NotFoundException;
import main.repository.ExpenseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseItemServiceImpl implements ExpenseItemService {

  @Autowired
  ExpenseItemRepository expenseItemRepository;

  @Override
  public ExpenseItem findExpenseItem(int id) {
    Optional<ExpenseItem> expenseItem = expenseItemRepository.findById(id);

    if (!expenseItem.isPresent()) {
      throw new NotFoundException();
    }

     return expenseItem.get();
  }

  @Override
  public List<ExpenseItem> listExpenseItems() {
    return (List<ExpenseItem>) expenseItemRepository.findAll();


  }

  @Override
  public void deleteExpenseItem(int id) {
    expenseItemRepository.deleteById(id);
  }

  @Override
  public void updateExpenseItem(int id, ExpenseItem newExpenseItem) {
    ExpenseItem expenseItem = findExpenseItem(id);
    expenseItem = newExpenseItem;
  }

  @Override
  public void save(ExpenseItem expenseItem) {
    expenseItemRepository.save(expenseItem);
  }
}
