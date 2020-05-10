package main.controller;

import main.entity.ExpenseItem;
import main.repository.ExpenseItemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO(SDELAT)
@RestController
@RequestMapping(value = "/expense_items")
public class StartController {


  private final ExpenseItemRepository expenseItemRepository;

  @Autowired
  public StartController(ExpenseItemRepository expenseItemRepository) {
    this.expenseItemRepository = expenseItemRepository;
  }

//  @GetMapping
//  public String start() {
//    return "index";
//  }

  @GetMapping(value = "/{id}") //nahodit po id, preobrazuet v object(6:39(1video))
  public ExpenseItem getItem(@PathVariable("id") ExpenseItem expenseItem){

    return expenseItem;
  }

  //@GetMapping("/expense_items")
  @GetMapping
  public ResponseEntity<List<ExpenseItem>> getAllExpenseItems() {

    List<ExpenseItem> expenseItemList = (List<ExpenseItem>) expenseItemRepository.findAll();

    return new ResponseEntity<>(expenseItemList, HttpStatus.OK);
  }

  @PostMapping
  public ExpenseItem create(@RequestBody ExpenseItem expenseItem) {
    return expenseItemRepository.save(expenseItem);
  }

  @PutMapping(value = "/{id}")
  public ExpenseItem updateExpenseItem(@PathVariable("id") ExpenseItem expenseItemFromDb, @RequestBody ExpenseItem expenseItem) {
    BeanUtils.copyProperties(expenseItem, expenseItemFromDb, "id");
    return expenseItemRepository.save(expenseItem);
  }

  @DeleteMapping("/{id}")
  public void deleteExpenseItem(@PathVariable("id") ExpenseItem expenseItem) {
    expenseItemRepository.delete(expenseItem);
  }

}
