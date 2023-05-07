package com.finalproject.jeffreysbeershop.entity;

import lombok.Builder;
import lombok.Data;

// The Customers class contains information associated with each customer. 

@Data
@Builder
public class Customers {
  private Long customersPK; 
  private Address address; 
  private String customerId; 
  private String firstName; 
  private String lastName; 
  private String phone; 
}
