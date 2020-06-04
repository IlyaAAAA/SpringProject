package main.controller;

import main.entity.Sale;
import main.service.saleService.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

  private final SaleService saleService;

  @Autowired
  public SaleController(SaleService saleService) {
    this.saleService = saleService;
  }


  @GetMapping(value = "/{id}")
  public ResponseEntity<Sale> getSale(@PathVariable("id") Sale sale){
    if (sale == null) {
      return new ResponseEntity<>(sale, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(sale, HttpStatus.OK);
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<Sale>> getAllESale() {

    List<Sale> saleList = saleService.getSaleList();

    return new ResponseEntity<>(saleList, HttpStatus.OK);
  }

  @PostMapping("/create")
  public Sale create(@RequestBody Sale sale) {
    return saleService.save(sale);
  }

  @PutMapping(value = "/{id}")
  public Sale updateExpenseItem(@PathVariable("id") Sale saleFromDb, @RequestBody Sale sale) {
    return saleService.update(saleFromDb, sale, "id");
  }

  @DeleteMapping("/{id}")
  public void deleteExpenseItem(@PathVariable("id") Sale sale) { saleService.delete(sale);
  }

}
