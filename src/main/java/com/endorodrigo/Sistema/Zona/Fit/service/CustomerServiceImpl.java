package com.endorodrigo.Sistema.Zona.Fit.service;

import com.endorodrigo.Sistema.Zona.Fit.model.Customer;
import com.endorodrigo.Sistema.Zona.Fit.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
    }
}
