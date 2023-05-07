package com.finalproject.jeffreysbeershop.entity;

/**
 *  The class will contain the order of each customer. 
 *  This has not yet been established yet. Will just include for theoretical purposes. 
 */

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Order {
  private Long orderPK; 
  private OrderItems orderItems;
  private Customers customer; 
  private BigDecimal orderTotal; 

}
