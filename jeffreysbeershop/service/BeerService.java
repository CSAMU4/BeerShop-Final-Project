package com.finalproject.jeffreysbeershop.service;

import java.util.List;
import java.util.Optional;
import com.finalproject.jeffreysbeershop.entity.Beer;
import com.finalproject.jeffreysbeershop.entity.BeerStyle;
import com.finalproject.jeffreysbeershop.entity.BeerType;

public interface BeerService {

  /**
   * 
   * @param beerId
   * @return
   */
  public List<Beer> fetchBeers(String beerId);

  public Optional<Beer> createBeers(String beerId, BeerType beerType, BeerStyle beerStyle);

  public Optional<Beer> updateBeers(String beerId, BeerType beerType, BeerStyle newBeerStyle);

  public Optional<Beer> deletePies(String beerId, BeerType beerType);

}
