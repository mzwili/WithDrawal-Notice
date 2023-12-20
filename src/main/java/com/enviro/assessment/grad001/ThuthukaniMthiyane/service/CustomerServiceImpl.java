package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.CustomerService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer getCustomer(){
        return this.customerRepository.findAll().get(0);
    }
}
