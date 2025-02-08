package com.endorodrigo.Sistema.Zona.Fit.service;

import com.endorodrigo.Sistema.Zona.Fit.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();
    Customer getCustomer(int id);
    void saveCustomer(Customer customer);
    void deleteCustomer(int id);
}
