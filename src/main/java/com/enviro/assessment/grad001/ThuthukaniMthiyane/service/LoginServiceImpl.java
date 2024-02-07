package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.UserLoginDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.LoginService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void getUserDetails(UserLoginDTO login){
        try {
            Customer customer = customerRepository.findByEmail(login.getLogInEmail());
            System.out.println(customer.getEmail());
            if(customer.getEmail().equals(login.getLogInEmail())){
                throw new RuntimeException("Customer not registered");
            }else if(bCryptPasswordEncoder.matches(login.getLogInPassword(), customer.getPassword())){
               throw new RuntimeException("Wrong Password");
            }
        }catch (RuntimeException e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
