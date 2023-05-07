package com.finalproject.jeffreysbeershop.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.finalproject.jeffreysbeershop.entity.Beer;
import com.finalproject.jeffreysbeershop.entity.BeerStyle;
import com.finalproject.jeffreysbeershop.entity.BeerType;
import com.finalproject.jeffreysbeershop.service.BeerService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class BasicBeerController implements BeerController {
  
  @Autowired
  private BeerService beerService;
  
  // get - get beer name 

  @Override
  public List<Beer> fetchBeers(String beerId) {
    log.info("beerId={}");
    return beerService.fetchBeers(beerId);
  }
// post - create beer list
  @Override
  public Optional<Beer> createBeers(String beerId, BeerType beerType, BeerStyle beerStyle) {
    log.info("beerId={}, beerType={}, beerStyle={}", beerId, beerType, beerStyle); ;
    return beerService.createBeers(beerId, beerType, beerStyle);
  }
// put - update beer name based on style 
  @Override
  public Optional<Beer> updateBeers(String beerId, BeerType beerType, BeerStyle newBeerStyle) {
    log.info("beerId={}, beerType={}, newBeerStyle={}", beerId, beerType, newBeerStyle); 
    return beerService.updateBeers(beerId, beerType, newBeerStyle);
  }
// delete - beers
  @Override
  public Optional<Beer> deleteBeers (String beerId, BeerType beerType) {
    log.info("beerId={}", beerType);
    return beerService.deleteBeers(beerId, beerType);
  }

}
