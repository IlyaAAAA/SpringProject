package main.service.chargeSevice;

import lombok.RequiredArgsConstructor;
import main.entity.Charge;
import main.repository.ChargeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChargeServiceImpl implements ChargeService {

  private final ChargeRepository chargeRepository;

  @Override
  public List<Charge> getChargeList() {
    return (List<Charge>) chargeRepository.findAll();
  }

  @Override
  public Charge save(Charge charge) {
    return chargeRepository.save(charge);
  }

  @Override
  public Charge update(Charge chargeFromDb, Charge charge, String field) {
    BeanUtils.copyProperties(charge, chargeFromDb, field);
    return chargeRepository.save(chargeFromDb);
  }

  @Override
  public void delete(Charge charge) {
    chargeRepository.delete(charge);
  }
}
