package main.service;

import main.entity.Warehouse;

import java.util.List;

public interface WarehouseService {
  Warehouse findWarehouse(int id);
  List<Warehouse> listWarehouse();
}
