package main.service.saleService;

import main.entity.ExpenseItem;
import main.entity.Sale;

import java.util.List;

public interface SaleService {
  List<Sale> getSaleList();
  Sale save(Sale sale);
  Sale update(Sale saleFromDb, Sale sale, String field);
  void delete(Sale sale);
}
