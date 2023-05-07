package com.finalproject.jeffreysbeershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Starts spring boot application 
 
@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class JeffreysBeerShop {

  public static void main(String[] args) {
    SpringApplication.run(JeffreysBeerShop.class, args);
  }
}
