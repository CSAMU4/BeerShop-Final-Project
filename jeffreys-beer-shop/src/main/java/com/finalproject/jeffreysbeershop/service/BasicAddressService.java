package com.finalproject.jeffreysbeershop.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.finalproject.jeffreysbeershop.dao.AddressDao;

import com.finalproject.jeffreysbeershop.entity.Address;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BasicAddressService implements AddressService {
  
  @Autowired
  private AddressDao addressDao;

  // @Transactional(readOnly = true)
  @Override // read address 
  public List<Address> fetchAddress(Long addressPK, String customerId) {
    log.info("The fetchAddress method was called with addressPK={}, customerId={}",
        addressPK, customerId); 
    return addressDao.fetchAddress(addressPK, customerId);
  }

  @Override // create address 
  public Optional<Address> createAddress(String customerId, String billingAddress,
      String shippingAddress) {
    log.info("The createAddress method was called with customerId={}, "
        + "billingAddress={}, shippingAddress={}", customerId, billingAddress, shippingAddress); 
    return addressDao.createAddress(customerId, billingAddress, shippingAddress);     
  }

  @Override // update address
  public Optional<Address> updateAddress(Long addressPK, String customerId, String billingAddress,
      String shippingAddress) {
    log.info("The updateAddress method was called with addressPK={}, customerId={}, billingAddress={},"
        + "shippingAddress", addressPK, customerId, billingAddress, shippingAddress);  
    return addressDao.updateAddress(addressPK, customerId, billingAddress, shippingAddress); 
  }

}
