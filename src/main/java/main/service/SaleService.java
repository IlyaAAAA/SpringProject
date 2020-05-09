package main.service;

import main.entity.Sale;

import java.util.List;

public interface SaleService {
  Sale findSale(int id);
  List<Sale> listSale();
}
