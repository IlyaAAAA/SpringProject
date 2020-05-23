package main.controller;

import main.entity.ExpenseItem;
import main.service.expenseItemService.ExpenseItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/expenseItems")
public class ExpenseItemController {


  private final ExpenseItemService expenseItemService;

  @Autowired
  public ExpenseItemController(ExpenseItemService expenseItemService) {
    this.expenseItemService = expenseItemService;
  }

  @ResponseBody
  @GetMapping(value = "/{id}") //nahodit po id, preobrazuet v object(6:39(1video))
  public ExpenseItem getItem(@PathVariable("id") ExpenseItem expenseItem){

    return expenseItem;
  }

  @ResponseBody
  @GetMapping(value = "/getAll")
  public ResponseEntity<List<ExpenseItem>> getAllExpenseItems() {

    List<ExpenseItem> expenseItemList = expenseItemService.getExpenseItemList();

    return new ResponseEntity<>(expenseItemList, HttpStatus.OK);
  }

  @ResponseBody
  @PostMapping("/create")
  public ExpenseItem create(@RequestBody ExpenseItem expenseItem) {
    return expenseItemService.save(expenseItem);
  }

  @ResponseBody
  @PutMapping("/{id}")
  public ExpenseItem updateExpenseItem(@PathVariable("id") ExpenseItem expenseItemFromDb, @RequestBody ExpenseItem expenseItem) {
    return expenseItemService.update(expenseItemFromDb, expenseItem, "id");
  }

  @ResponseBody
  @DeleteMapping("/{id}")
  public void deleteExpenseItem(@PathVariable("id") ExpenseItem expenseItem) {
    expenseItemService.delete(expenseItem);
  }

}
