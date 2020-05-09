package main.repository;

import main.entity.ExpenseItem;
import org.springframework.data.repository.CrudRepository;

public interface ExpenseItemRepository extends CrudRepository<ExpenseItem, Integer> {
}
