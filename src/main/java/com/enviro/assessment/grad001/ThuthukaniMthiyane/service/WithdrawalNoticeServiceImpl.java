package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.WithDrawDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.WithdrawalNoticeService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.CustomerRepository;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WithdrawalNoticeServiceImpl implements WithdrawalNoticeService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    EmailService emailService;


    @Override
    public void withdrawalProcess(WithDrawDTO withDrawDTO, String email) {
        Product investmentProduct =  productRepository.findByName(withDrawDTO.getName());
        if(!investmentProduct.getName().equalsIgnoreCase(withDrawDTO.getName())){
            throw new RuntimeException("Investment does not exist!");
        }
        //use token to get email
        Customer investor = customerRepository.findByEmail(email);
        long balance = 0;
        withdrawalLogic(withDrawDTO.getAmount(), investmentProduct,investor,balance);
    }

    public void sendNotification(Customer customer, Product investment, long withdrawalAmount, long balance){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(customer.getEmail());
            simpleMailMessage.setSubject("Withdrawal Notice");
            simpleMailMessage.setText("PreWithdrawal Balance: "+ investment.getBalance() + '\n'+ "WithdrawalAmount: "+withdrawalAmount + '\n' + "Closing Balance: "+ balance);
            emailService.sendEmail(simpleMailMessage);
        }catch (RuntimeException e){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, e.getMessage(),e);
        }
    }

    public void withdrawalLogic(long amount, Product product, Customer investor, long balance){
        try {
            long balance90 = (long) (product.getBalance() * 0.9f);
            if(amount > product.getBalance()){
                throw new RuntimeException("InSufficient Funds");
            }else if(product.getType().equalsIgnoreCase("retirement") && investor.getAge() <= 65){
                throw new RuntimeException("Ineligible for withdrawal");
            }else if(amount > balance90){
                throw new RuntimeException("Withdrawal amount greater then 90% of Balance");
            }else{
                balance = product.getBalance() - amount;
                sendNotification(investor, product,amount,balance);
                product.setBalance(balance);
                productRepository.save(product);
            }
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage(),ex);
        }
    }




}
