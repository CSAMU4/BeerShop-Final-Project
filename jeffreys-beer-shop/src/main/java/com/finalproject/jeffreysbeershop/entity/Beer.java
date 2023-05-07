package com.finalproject.jeffreysbeershop.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Beer {
  private Long beerPK; 
  private String beer_id; 
  private BeerType beer_type;
  private BeerStyle beer_style;
}
