package main.service.warehouseService;

import main.entity.Warehouse;
import main.exceptions.NotFoundException;
import main.repository.WarehouseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {

  private final WarehouseRepository warehouseRepository;

  @Autowired
  public WarehouseServiceImpl(WarehouseRepository warehouseRepository) {
    this.warehouseRepository = warehouseRepository;
  }

  @Override
  public List<Warehouse> getWarehouseList() {
    return (List<Warehouse>) warehouseRepository.findAll();
  }

  @Override
  public Warehouse save(Warehouse warehouse) {
    return warehouseRepository.save(warehouse);
  }

  @Override
  public Warehouse update(Warehouse warehouseFromDb, Warehouse warehouse, String field) {
    BeanUtils.copyProperties(warehouse, warehouseFromDb, field);
    return warehouseRepository.save(warehouseFromDb);
  }

  @Override
  public void delete(Warehouse warehouse) {
    warehouseRepository.delete(warehouse);
  }
}
