package main.service.expenseItemService;

import main.entity.ExpenseItem;
import main.repository.ExpenseItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseItemServiceImpl implements ExpenseItemService {

  private final ExpenseItemRepository expenseItemRepository;

  @Autowired
  public ExpenseItemServiceImpl(ExpenseItemRepository expenseItemRepository) {
    this.expenseItemRepository = expenseItemRepository;
  }

  @Override
  public List<ExpenseItem> getExpenseItemList() {
    return (List<ExpenseItem>) expenseItemRepository.findAll();
  }

  @Override
  public ExpenseItem save(ExpenseItem expenseItem) {
    return expenseItemRepository.save(expenseItem);
  }

  @Override
  public ExpenseItem update(ExpenseItem expenseItemFromDb, ExpenseItem expenseItem, String field) {
    BeanUtils.copyProperties(expenseItem, expenseItemFromDb, field);
    return expenseItemRepository.save(expenseItemFromDb);
  }

  @Override
  public void delete(ExpenseItem expenseItem) {
    expenseItemRepository.delete(expenseItem);
  }
}
