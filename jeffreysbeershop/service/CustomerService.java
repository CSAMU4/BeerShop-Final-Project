package com.finalproject.jeffreysbeershop.service;

import java.util.List;
import java.util.Optional;
import com.finalproject.jeffreysbeershop.entity.Customers;

public interface CustomerService {

  /**
   * 
   * @param customerPK
   * @param customerId
   * @return
   */
  public List<Customers> fetchCustomers(Long customerPK, String customerId);

  public Optional<Customers> createCustomers(String customerId, String firstName, String lastName,
      String phone);

  public Optional<Customers> updateCustomers(String customerId, String firstName, String lastName,
      String phone, String newFirstName, String newLastName, String newPhone);

}
