package main.controller;

import lombok.RequiredArgsConstructor;
import main.service.chargeSevice.ChargeService;
import main.service.expenseItemService.ExpenseItemService;
import main.service.saleService.SaleService;
import main.service.warehouseService.WarehouseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class TemplateController {

  private final ExpenseItemService expenseItemService;
  private final WarehouseService warehouseService;
  private final ChargeService chargeService;
  private final SaleService saleService;


  @GetMapping("expenseItems")
  public String expenseItemsPage(Model model) {
    model.addAttribute("expenseItemsList", expenseItemService.getExpenseItemList());

    return "expenseItems";
  }

  @GetMapping("warehouses")
  public String warehousesPage(Model model) {
    model.addAttribute("warehousesList", warehouseService.getWarehouseList());

    return "warehouses";
  }

  @GetMapping("charges")
  public String chargesPage(Model model) {
    model.addAttribute("chargesList", chargeService.getChargeList());

    return "charges";
  }

  @GetMapping("sales")
  public String salesPage(Model model) {
    model.addAttribute("salesList", saleService.getSaleList());

    return "sales";
  }
}
