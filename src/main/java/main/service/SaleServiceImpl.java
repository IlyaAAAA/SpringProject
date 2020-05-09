package main.service;

import main.entity.Sale;
import main.exceptions.NotFoundException;
import main.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImpl implements SaleService {

  @Autowired
  SaleRepository saleRepository;

  @Override
  public Sale findSale(int id) {

    Optional<Sale> sale = saleRepository.findById(id);

    if (!sale.isPresent()) {
      throw new NotFoundException();
    }

    return sale.get();
  }

  @Override
  public List<Sale> listSale() {
    return (List<Sale>) saleRepository.findAll();
  }
}
