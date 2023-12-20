package com.enviro.assessment.grad001.ThuthukaniMthiyane.controller;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.POJO.NoticeResponse;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.CustomerServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.ProductServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.WithdrawalNoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
    private NoticeResponse noticeMessage;

    @GetMapping("/details")
    public Customer getUserDetails(){
        return  customerServiceImpl.getCustomer();
    };
    @GetMapping("/investments")
    public List<Product> getAllUsers() {
        return productServiceImpl.getAllProduct();
    };

    @PostMapping("/notice")
    public NoticeResponse noticeNotification(@RequestParam("productName")String productName, @RequestParam("withdrawalAmount")long withdrawalAmount,
                                            @RequestParam("date")String date, @RequestParam("bankName")String bankName, @RequestParam("bankAmount")long bankAmount){
        withdrawalNoticeServiceImpl.withdrawalProcess(productName,withdrawalAmount,date,bankName,bankAmount);
        noticeMessage = new NoticeResponse(withdrawalNoticeServiceImpl.withdrawalResponse());
        return noticeMessage;
    }


}
