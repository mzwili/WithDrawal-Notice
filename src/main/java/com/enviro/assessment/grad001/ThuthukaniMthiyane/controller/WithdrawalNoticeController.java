package com.enviro.assessment.grad001.ThuthukaniMthiyane.controller;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.CustomerServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.ProductServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.WithdrawalNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class WithdrawalNoticeController {

    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private CustomerServiceImpl  customerServiceImpl;
    @Autowired
    private WithdrawalNoticeServiceImpl withdrawalNoticeServiceImpl;


    @GetMapping("/details")
    public ResponseEntity<Customer> getUserDetails(){
        try {
            return  new ResponseEntity<>(customerServiceImpl.getCustomer(), HttpStatus.OK);
        }catch (RuntimeException e){
            return new ResponseEntity<>(customerServiceImpl.getCustomer(), HttpStatus.NOT_FOUND);
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
    public ResponseEntity<String> noticeNotification(@RequestParam("productName")String productName, @RequestParam("withdrawalAmount")long withdrawalAmount,
                                            @RequestParam("date")String date, @RequestParam("bankName")String bankName, @RequestParam("bankAccountNumber")long bankAccountNumber){
       try {
           withdrawalNoticeServiceImpl.withdrawalProcess(productName,withdrawalAmount,date,bankName,bankAccountNumber);
       }catch (RuntimeException ex){
          return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
       }
        return new ResponseEntity<>("Notification Sent", HttpStatus.OK);
    }




}
