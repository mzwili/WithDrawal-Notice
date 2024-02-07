package com.enviro.assessment.grad001.ThuthukaniMthiyane.controller;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping(value = "/signup", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<String> userSignUp(SignUpDTO signUp){
        try {
            userServiceImpl.save(signUp);
            return new ResponseEntity<>("User SignUp successfull", HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
