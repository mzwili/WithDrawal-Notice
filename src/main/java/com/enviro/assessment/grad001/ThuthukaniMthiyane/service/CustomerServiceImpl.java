package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.CustomerService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer getCustomer(String email) {
        //still going to change to make it more dynamic
        try {
            return this.customerRepository.findByEmail(email);

        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(),e);
        }
    }

}
