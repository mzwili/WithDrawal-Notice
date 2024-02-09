package com.enviro.assessment.grad001.ThuthukaniMthiyane.controller;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.InvestDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignInDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.ProductServiceImpl;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ProductServiceImpl productServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> userSignUp(@Valid @RequestBody SignUpDTO signUp){
        try {
            userServiceImpl.save(signUp);
            return new ResponseEntity<>("User SignUp successfull", HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PostMapping("/signin")
    public ResponseEntity<String> customerLoginIn(@Valid @RequestBody SignInDTO userLogin){
        try {
            userServiceImpl.userLogin(userLogin);
            return new ResponseEntity<>("Successfully LoggedIn", HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/newinvestment")
    public ResponseEntity<String> createInvestment(@Valid @RequestBody InvestDTO investDTO){
        try {
            productServiceImpl.createProduct(investDTO);
            return new ResponseEntity<>("Successfully created",HttpStatus.CREATED);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

}
