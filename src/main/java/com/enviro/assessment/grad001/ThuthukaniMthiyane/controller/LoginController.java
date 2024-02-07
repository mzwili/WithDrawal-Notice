package com.enviro.assessment.grad001.ThuthukaniMthiyane.controller;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.UserLoginDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginServiceImpl loginServiceImpl;
    @PostMapping(value = "/signin", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public ResponseEntity<String> customerLoginIn(UserLoginDTO userLogin){
        try {
            loginServiceImpl.getUserDetails(userLogin);
            return new ResponseEntity<>("Successfully LoggedIn", HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
