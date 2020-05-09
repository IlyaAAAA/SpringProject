package main.service;

import main.entity.Charge;
import main.exceptions.NotFoundException;
import main.repository.ChargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChargeServiceImpl implements ChargeService {

  @Autowired
  ChargeRepository chargeRepository;

  @Override
  public Charge findCharge(int id) {
    Optional<Charge> charge = chargeRepository.findById(id);

    if (!charge.isPresent()) {
      throw new NotFoundException();
    }

    return charge.get();
  }

  @Override
  public List<Charge> listCharge() {
    return (List<Charge>) chargeRepository.findAll();
  }
}
