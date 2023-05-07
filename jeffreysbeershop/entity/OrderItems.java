package com.finalproject.jeffreysbeershop.entity;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * 
 * This class consists of each order item that will be placed in an order. 
 * 
 *
 */

@Data
@Builder
public class OrderItems {
  private Long orderItemPK; 
  private List<Beer> beers; 
  private PricePerSixPackBeer pricePerSixPackBeer; 
}
