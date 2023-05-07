package com.finalproject.jeffreysbeershop.service;

import java.util.List;
import java.util.Optional;
import com.finalproject.jeffreysbeershop.entity.Address;

public interface AddressService {

  /**
   * 
   * @param addressPK
   * @param customerId
   * @return
   */
  public List<Address> fetchAddress(Long addressPK, String customerId);

  public Optional<Address> createAddress(String customerId, String billingAddress,
      String shippingAddress);

  public Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress,
      String shippingAddress);

}
