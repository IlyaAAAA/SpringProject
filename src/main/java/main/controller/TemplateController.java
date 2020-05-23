package main.controller;

import lombok.RequiredArgsConstructor;
import main.service.expenseItemService.ExpenseItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TemplateController {

  private final ExpenseItemService expenseItemService;


  @GetMapping("expenseItems")
  public String expenseItemPage(Model model) {
    model.addAttribute("expenseItemsList", expenseItemService.getExpenseItemList());

    return "expenseItems";
  }
}
