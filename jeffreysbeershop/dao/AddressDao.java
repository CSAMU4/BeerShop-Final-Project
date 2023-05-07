package com.finalproject.jeffreysbeershop.dao;

import java.util.List;
import java.util.Optional;
import com.finalproject.jeffreysbeershop.entity.Address;

public interface AddressDao {
  /**
   * 
   * @param addressPK
   * @param customerId
   * @return
   */

  List<Address> fetchAddress(Long addressPK, String customerId);

  /**
   * 
   * @param customerId
   * @param billingAddress
   * @param shippingAddress
   * @return
   */
  Optional<Address> createAddress(String customerId, String billingAddress, String shippingAddress);
  /**
   * 
   * @param addressPK
   * @param customerId
   * @param billingAddress
   * @param shippingAddress
   * @return
   */
  Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress,
      String shippingAddress);
}
