package main.controller;

import lombok.RequiredArgsConstructor;
import main.entity.ExpenseItem;
import main.service.expenseItemService.ExpenseItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenseItems")
@RequiredArgsConstructor
public class ExpenseItemController {


  private final ExpenseItemService expenseItemService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<ExpenseItem> getItem(@PathVariable("id") ExpenseItem expenseItem){

    if (expenseItem == null) {
      return new ResponseEntity<>(expenseItem, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(expenseItem, HttpStatus.OK);
  }

  @GetMapping(value = "/getAll")
  public ResponseEntity<List<ExpenseItem>> getAllExpenseItems() {

    List<ExpenseItem> expenseItemList = expenseItemService.getExpenseItemList();

    return new ResponseEntity<>(expenseItemList, HttpStatus.OK);
  }

  @PostMapping("/create")
  public ExpenseItem create(@RequestBody ExpenseItem expenseItem) {
    return expenseItemService.save(expenseItem);
  }

  @PutMapping("/{id}")
  public ExpenseItem updateExpenseItem(@PathVariable("id") ExpenseItem expenseItemFromDb, @RequestBody ExpenseItem expenseItem) {
    return expenseItemService.update(expenseItemFromDb, expenseItem, "id");
  }

  @DeleteMapping("/{id}")
  public void deleteExpenseItem(@PathVariable("id") ExpenseItem expenseItem) {
    try {
      expenseItemService.delete(expenseItem);
    }
    catch (Exception e) {
      System.out.println("От этого объекта зависит другой.");;
    }
  }

}
