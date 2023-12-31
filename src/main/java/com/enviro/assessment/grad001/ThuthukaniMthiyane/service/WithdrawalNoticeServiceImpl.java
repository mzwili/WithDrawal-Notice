package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Product;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.WithdrawalNoticeService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.CustomerRepository;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class WithdrawalNoticeServiceImpl implements WithdrawalNoticeService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    EmailService emailService;
    private String finalResponse;
    public WithdrawalNoticeServiceImpl(ProductRepository productRepo, CustomerRepository customerRepo){
        this.productRepository = productRepo;
        this.customerRepository = customerRepo;
    }

    @Override
    public void withdrawalProcess(String productName, Long withdrawalAmount, String date,
                                  String bankName, long bankAccountNumber)
    {
        try {
            System.out.println(productName);
            Product investmentProduct =  productRepository.findByName(productName);
            Customer investor = customerRepository.findAll().get(0);
            long balance = 0;
            withdrawalLogic(withdrawalAmount, investmentProduct,investor,balance);

        }catch (Exception e){
            System.out.println("An error occurred while processing your request: " + e.getMessage());
        }

    };

    public String withdrawalResponse(){
        return this.finalResponse;
    }

    public void setFinalResponse(String finalResponse) {
        this.finalResponse = finalResponse;
    }

    public void sendNotification(Customer customer, Product investment, long withdrawalAmount, long balance){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(customer.getEmail());
        simpleMailMessage.setSubject("Withdrawal Notice");
        simpleMailMessage.setText("PreWithdrawal Balance: "+ investment.getBalance() + '\n'+ "WithdrawalAmount: "+withdrawalAmount + '\n' + "Closing Balance: "+ balance);
        emailService.sendEmail(simpleMailMessage);
    }

    public void withdrawalLogic(long amount, Product product, Customer investor, long balance){
        long balance90 = (long) (product.getBalance() * 0.9f);
        if(amount > product.getBalance()){
            setFinalResponse("InSufficient Funds");
        }else if(product.getType().equalsIgnoreCase("retirement") && investor.getAge() <= 65){
            setFinalResponse("Ineligible for withdrawal");
        }else if(amount > balance90){
            setFinalResponse("Withdrawal amount greater then 90% of Balance");
        }else{
            balance = product.getBalance() - amount;
            sendNotification(investor, product,amount,balance);
            product.setBalance(balance);
            productRepository.save(product);
            setFinalResponse("Email Notification sent");
        }
    }
}
