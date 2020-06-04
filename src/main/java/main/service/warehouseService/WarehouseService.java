package main.service.warehouseService;

import main.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
  List<Warehouse> getWarehouseList();
  Warehouse save(Warehouse warehouse);
  Warehouse update(Warehouse warehouseFromDb, Warehouse warehouse, String field);
  void delete(Warehouse warehouse);
}
