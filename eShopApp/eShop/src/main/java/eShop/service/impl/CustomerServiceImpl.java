package eShop.service.impl;

import eShop.model.user.Customer;
import eShop.repository.CustomerRepository;
import eShop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer getCustomerById(Integer id) {
       return customerRepository.findById(id).orElse(null);
    }
}
