package com.finalproject.jeffreysbeershop.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

  /* To keep things simple, the shop only sells six-pack beer. 
   * Inside this class, CREATE, READ, UPDATE operations are used. 
   */

@Data
@Builder
public class PricePerSixPackBeer {
  private Long PricePerSixPackBeerPK; 
  private Beer beer; 
  private BigDecimal pricePerSixPackBeer;

}
