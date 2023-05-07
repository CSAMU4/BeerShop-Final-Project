package com.finalproject.jeffreysbeershop.dao;

import java.util.List;
import java.util.Optional;
import com.finalproject.jeffreysbeershop.entity.Beer;
import com.finalproject.jeffreysbeershop.entity.BeerStyle;
import com.finalproject.jeffreysbeershop.entity.BeerType;

public interface BeerDao {

  Optional<Beer> createBeers(String beerId, BeerType beerType, BeerStyle beerStyle);
  /**
   * 
   * @param beerId
   * @return
   */
  List<Beer> fetchBeers(String beerId);
  /**
   * 
   * @param beerId
   * @param beerType
   * @param beerStyle
   * @return
   */
  
  /**
   * 
   * @param beerId
   * @param beerType
   * @param newBeerStyle
   * @return
   */
  Optional<Beer> updateBeers(String beerId, BeerType beerType, BeerStyle newBeerStyle);
  /**
   * 
   * @param beerId
   * @param beerType
   * @return
   */
  Optional<Beer> deleteBeers(String beerId, BeerType beerType);

}
