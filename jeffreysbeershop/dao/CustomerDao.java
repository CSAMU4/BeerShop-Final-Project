package com.finalproject.jeffreysbeershop.dao;

import java.util.List;
import java.util.Optional;
import com.finalproject.jeffreysbeershop.entity.Customers;

public interface CustomerDao {

  List<Customers> fetchCustomers(Long customerPK, String customerId);

  Optional<Customers> createCustomers(String customerId, String firstName, String lastName,
      String phone);

  Optional<Customers> updateCustomers(String customerId, String firstName, String lastName,
      String phone, String newFirstName, String newLastName, String newPhone);

}
