package com.finalproject.jeffreysbeershop.entity;

import lombok.Builder;
import lombok.Data;

// The Address class will contain all addresses linked to each customer. 

@Data
@Builder
public class Address {
  private Long addressPK; 
  private Customers customer; 
  private String billingAddress; 
  private String shippingAddress; 
  
}
