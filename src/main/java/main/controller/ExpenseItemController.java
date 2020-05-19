package main.controller;

import main.entity.ExpenseItem;
import main.service.expenseItemService.ExpenseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO(SDELAT)
@RestController
@RequestMapping("/user/expense_items")
public class ExpenseItemController {


  private final ExpenseItemService expenseItemService;

  @Autowired
  public ExpenseItemController(ExpenseItemService expenseItemService) {
    this.expenseItemService = expenseItemService;
  }


  @GetMapping(value = "/{id}") //nahodit po id, preobrazuet v object(6:39(1video))
  public ExpenseItem getItem(@PathVariable("id") ExpenseItem expenseItem){

    return expenseItem;
  }

  @GetMapping
  public ResponseEntity<List<ExpenseItem>> getAllExpenseItems() {

    List<ExpenseItem> expenseItemList = expenseItemService.getExpenseItemList();

    return new ResponseEntity<>(expenseItemList, HttpStatus.OK);
  }

  @PostMapping
  public ExpenseItem create(@RequestBody ExpenseItem expenseItem) {
    return expenseItemService.save(expenseItem);
  }

  @PutMapping(value = "/{id}")
  public ExpenseItem updateExpenseItem(@PathVariable("id") ExpenseItem expenseItemFromDb, @RequestBody ExpenseItem expenseItem) {
    return expenseItemService.update(expenseItemFromDb, expenseItem, "id");
  }

  @DeleteMapping("/{id}")
  public void deleteExpenseItem(@PathVariable("id") ExpenseItem expenseItem) {
    expenseItemService.delete(expenseItem);
  }

}
