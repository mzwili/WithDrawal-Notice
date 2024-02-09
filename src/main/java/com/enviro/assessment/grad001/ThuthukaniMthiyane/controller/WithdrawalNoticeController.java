package com.enviro.assessment.grad001.ThuthukaniMthiyane.controller;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.WithDrawDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.CustomerServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.ProductServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.UserServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.WithdrawalNoticeServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class WithdrawalNoticeController {

    @Autowired
    private UserServiceImpl currentUser;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private CustomerServiceImpl  customerServiceImpl;
    @Autowired
    private WithdrawalNoticeServiceImpl withdrawalNoticeServiceImpl;


    @GetMapping("/details")
    public ResponseEntity<Customer> getUserDetails(){
        Customer customer = customerServiceImpl.getCustomer(currentUser.investor().getEmail());
        try {
            return  new ResponseEntity<>(customer, HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(customer, HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping("/investments")
    public ResponseEntity<List<Product>> getAllUsers() {
        try {
            return new ResponseEntity<>(productServiceImpl.getAllProduct(), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(productServiceImpl.getAllProduct(),HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/notice")
    public ResponseEntity<String> noticeNotification(@Valid @RequestBody WithDrawDTO withdrawal){
       try {
           withdrawalNoticeServiceImpl.withdrawalProcess(withdrawal, currentUser.investor().getEmail());
           return new ResponseEntity<>("Notification Sent", HttpStatus.OK);
       }catch (RuntimeException ex){
          return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
       }

    }




}
