package com.finalproject.jeffreysbeershop.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finalproject.jeffreysbeershop.dao.BeerDao;
import com.finalproject.jeffreysbeershop.entity.Beer;
import com.finalproject.jeffreysbeershop.entity.BeerStyle;
import com.finalproject.jeffreysbeershop.entity.BeerType;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicBeerService implements BeerService {

  @Autowired
  private BeerDao beerDao;

  @Override
  public List<Beer> fetchBeers(String beerId) {
    log.info("The fetchBeers method was called with beerId={}", beerId);
    return beerDao.fetchBeers(beerId);
  }

  @Override
  public Optional<Beer> createBeers(String beerId, BeerType beerType, BeerStyle beerStyle) {
    log.info("The createBeers method was called with beerId={}, beerType={}, beerStyle={}", 
        beerId, beerType, beerStyle); 
     return beerDao.createBeers(beerId, beerType, beerStyle);
  }
  @Override
  public Optional<Beer> updateBeers(String beerId, BeerType beerType, BeerStyle newBeerStyle) {
    log.info("The updateBeers method was called with beerId={}, beerType={}", beerId, beerType);   
    return beerDao.updateBeers(beerId, beerType, newBeerStyle); 
  }

  @Override
  public Optional<Beer> deleteBeers (String beerId, BeerType beerType) {
    return beerDao.deleteBeers (beerId, beerType); 
  }

}
