package main.controller;

import main.entity.Warehouse;
import main.service.warehouseService.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/warehouse")
public class WarehouseController {

  private final WarehouseService warehouseService;

  @Autowired
  public WarehouseController(WarehouseService warehouseService) {
    this.warehouseService = warehouseService;
  }

  @GetMapping(value = "/{id}") //nahodit po id, preobrazuet v object(6:39(1video))
  public Warehouse getItem(@PathVariable("id") Warehouse warehouse){

    return warehouse;
  }

  @GetMapping
  public ResponseEntity<List<Warehouse>> getAllWarehouse() {

    List<Warehouse> warehousesList = warehouseService.getWarehouseList();

    return new ResponseEntity<>(warehousesList, HttpStatus.OK);
  }

  @PostMapping
  public Warehouse create(@RequestBody Warehouse warehouse) {
    return warehouseService.save(warehouse);
  }

  @PutMapping(value = "/{id}")
  public Warehouse updateExpenseItem(@PathVariable("id") Warehouse warehouseFromDb, @RequestBody Warehouse warehouse) {
    return warehouseService.update(warehouseFromDb, warehouse, "id");
  }

  @DeleteMapping("/{id}")
  public void deleteExpenseItem(@PathVariable("id") Warehouse warehouse) {
    warehouseService.delete(warehouse);
  }

}