package com.enviro.assessment.grad001.ThuthukaniMthiyane.service;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.entity.Customer;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces.UserService;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.repository.CustomerRepository;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.validations.AgeValidation;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.validations.ContactNumberValidation;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.validations.EmailValidator;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.validations.PasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService {
    private Customer customer;
    private EmailValidator emailValidator;
    private PasswordValidator passwordValidator;
    private AgeValidation ageValidation;
    private ContactNumberValidation contactNumberValidation;
    @Autowired
    private EmailService emailService;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public void save(SignUpDTO signUpDTO){
        emailValidator = new EmailValidator();
        passwordValidator = new PasswordValidator();
        ageValidation = new AgeValidation();
        contactNumberValidation = new ContactNumberValidation();

        try {
            if (customerRepository.existsByEmail(signUpDTO.getEmail())) {
                throw new RuntimeException("Customer already exits");
            }else if (!emailValidator.validateEmail(signUpDTO) || emailValidator.emailNull(signUpDTO)){
                throw new RuntimeException("Email not valid");
            }else if (!passwordValidator.validPassword(signUpDTO) || !passwordValidator.matchingPassword(signUpDTO)
                    || passwordValidator.nullPassword(signUpDTO)) {
                throw new RuntimeException("Password not valid");
            }else if(!ageValidation.validateAge(signUpDTO)){
                throw new RuntimeException("You are under age");
            }else if(!contactNumberValidation.validateContact(signUpDTO)){
                throw new RuntimeException("Contact number not valid");
            }else{
                customer = new Customer();
                setCustomerDetail(signUpDTO);
                customerRepository.save(customer);
                sendEmail(customer.getEmail());
            }

        }catch (Exception ex){
                throw new RuntimeException(ex.getMessage());
        }

    }

    public void sendEmail(String email){
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(email);
            simpleMailMessage.setSubject("Registration Success");
            simpleMailMessage.setText("You have signed in");
            emailService.sendEmail(simpleMailMessage);
        }catch (RuntimeException ex){
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, ex.getMessage(),ex);
        }
    }

    public void setCustomerDetail(SignUpDTO sigUpData){
        try {
            customer.setFullName(sigUpData.getFullName());
            customer.setEmail(sigUpData.getEmail());
            customer.setAge(Integer.parseInt(sigUpData.getAge()));
            customer.setContactNumber(sigUpData.getContactNumber());
            customer.setPassword(bCryptPasswordEncoder.encode(sigUpData.getPassword()));
        }catch (RuntimeException ex){
            throw new RuntimeException("Error at setCustomerDetails " +ex.getMessage());
        }
    }
}
