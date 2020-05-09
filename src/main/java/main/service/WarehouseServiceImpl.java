package main.service;

import main.entity.Warehouse;
import main.exceptions.NotFoundException;
import main.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

  @Autowired
  WarehouseRepository warehouseRepository;

  @Override
  public Warehouse findWarehouse(int id) {

    Optional<Warehouse> warehouse = warehouseRepository.findById(id);

    if (!warehouse.isPresent()) {
      throw new NotFoundException();
    }

    return warehouse.get();
  }

  @Override
  public List<Warehouse> listWarehouse() {
    return (List<Warehouse>) warehouseRepository.findAll();
  }
}
