package main.repository;

import main.entity.Charge;
import org.springframework.data.repository.CrudRepository;

public interface ChargeRepository extends CrudRepository<Charge, Integer> {
}
