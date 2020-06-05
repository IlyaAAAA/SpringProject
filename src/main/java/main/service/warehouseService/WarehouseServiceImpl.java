package main.service.warehouseService;

import lombok.RequiredArgsConstructor;
import main.entity.Warehouse;
import main.repository.WarehouseRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

  private final WarehouseRepository warehouseRepository;

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
