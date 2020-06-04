package main.service.chargeSevice;

import main.entity.Charge;

import java.util.List;

public interface ChargeService {
  List<Charge> getChargeList();
  Charge save(Charge charge);
  Charge update(Charge chargeFromDb, Charge charge, String field);
  void delete(Charge charge);
}
