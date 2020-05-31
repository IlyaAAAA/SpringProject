package main.controller;

import main.entity.Charge;
import main.service.chargeSevice.ChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/charges")
public class ChargeController {

  private final ChargeService chargeService;

  @Autowired
  public ChargeController(ChargeService chargeService) {
    this.chargeService = chargeService;
  }

  @GetMapping(value = "/{id}")
  public Charge getCharge(@PathVariable("id") Charge charge){

    return charge;
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<Charge>> getAllCharge() {

    List<Charge> chargeListList = chargeService.getChargeList();

    return new ResponseEntity<>(chargeListList, HttpStatus.OK);
  }

  @PostMapping("/create")
  public Charge create(@RequestBody Charge charge) {
    return chargeService.save(charge);
  }

  @PutMapping(value = "/{id}")
  public Charge updateCharge(@PathVariable("id") Charge chargeFromDb, @RequestBody Charge charge) {
    return chargeService.update(chargeFromDb, charge, "id");
  }

  @DeleteMapping("/{id}")
  public void deleteCharge(@PathVariable("id") Charge charge) {
    chargeService.delete(charge);
  }

}
