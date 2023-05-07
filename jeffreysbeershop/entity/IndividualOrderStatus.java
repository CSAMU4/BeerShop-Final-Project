package com.finalproject.jeffreysbeershop.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IndividualOrderStatus {
  private Long orderStatusPK; 
  private Order order; 
  private Customers customer; 
  private OrderStatus orderStatus; 
  private ShippingStatus shippingStatus; 
  
  

}
