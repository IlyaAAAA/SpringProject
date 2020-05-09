package main.service;

import main.entity.Charge;

import java.util.List;

public interface ChargeService {
  Charge findCharge(int id);
  List<Charge> listCharge();
}
