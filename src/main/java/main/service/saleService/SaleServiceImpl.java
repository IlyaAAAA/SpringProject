package main.service.saleService;

import lombok.RequiredArgsConstructor;
import main.entity.Sale;
import main.repository.SaleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {

  private final SaleRepository saleRepository;

  @Override
  public List<Sale> getSaleList() {
    return (List<Sale>) saleRepository.findAll();
  }

  @Override
  public Sale save(Sale sale) {
    return saleRepository.save(sale);
  }

  @Override
  public Sale update(Sale saleFromDb, Sale sale, String field) {
    BeanUtils.copyProperties(sale, saleFromDb, field);
    return saleRepository.save(saleFromDb);
  }

  @Override
  public void delete(Sale sale) {
    saleRepository.delete(sale);
  }
}
