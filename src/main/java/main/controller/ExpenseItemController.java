package main.controller;

import main.entity.ExpenseItem;
import main.exceptions.NotFoundException;
import main.service.expenseItemService.ExpenseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenseItems")
public class ExpenseItemController {


  private final ExpenseItemService expenseItemService;

  @Autowired
  public ExpenseItemController(ExpenseItemService expenseItemService) {
    this.expenseItemService = expenseItemService;
  }

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
    expenseItemService.delete(expenseItem);
  }

}
