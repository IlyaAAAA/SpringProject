package main.controller;

import main.SpringWebApplication;
import main.entity.ExpenseItem;
import main.service.ExpenseItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO(SDELAT)
@RestController
@RequestMapping(value = "/expense_items")
public class StartController {


  @Autowired
  private ExpenseItemService expenseItemService;

//  @GetMapping
//  public String start() {
//    return "index";
//  }

  @GetMapping(value = "/{id}")
  public ExpenseItem getItem(@PathVariable int id){

    ExpenseItem expenseItem = expenseItemService.findExpenseItem(id);


    return expenseItem;
  }

  //@GetMapping("/expense_items")
  @GetMapping
  public ResponseEntity<List<ExpenseItem>> getAllExpenseItems() {

    List<ExpenseItem> expenseItemList = expenseItemService.listExpenseItems();

    return new ResponseEntity<>(expenseItemList, HttpStatus.OK);
  }

  @PostMapping
  public ExpenseItem create(@PathVariable("id") ExpenseItem expenseItem) {
    expenseItemService.save(expenseItem); //nahodi po id, preobrazuet v object(6:39(1video))
    return expenseItemService.findExpenseItem(expenseItem.getId());
  }

  @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ExpenseItem updateExpenseItem(@PathVariable("id") ExpenseItem expenseItemFromDb, @RequestBody ExpenseItem expenseItem) {
    //expenseItemService.updateExpenseItem(id, expenseItem);
    BeanUtils.copyProperties(expenseItem, expenseItemFromDb, "id");
    expenseItemService.save(expenseItem);

    return expenseItemService.findExpenseItem(expenseItem.getId());
  }

  @DeleteMapping("/{id}")
  public void deleteExpenseItem(@PathVariable int id) {
    expenseItemService.deleteExpenseItem(id);
  }

}
