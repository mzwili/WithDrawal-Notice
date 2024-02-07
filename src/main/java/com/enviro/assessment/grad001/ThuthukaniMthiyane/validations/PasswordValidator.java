package com.enviro.assessment.grad001.ThuthukaniMthiyane.validations;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidator {
    private Pattern pattern;
    private Matcher matcher;

    //regex ensures that the password is 8-50 in length, does contain a digit, special charactor and it's not empty
    private static final String NUMBER_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d@$!%*?&]{8,50}$";
    public boolean matchingPassword(SignUpDTO user){
        return user.getPassword().equals(user.getConfirmationPassword());
    }

    public boolean validPassword(SignUpDTO user){
        pattern = Pattern.compile(NUMBER_PATTERN);
        matcher = pattern.matcher(user.getPassword());
        return matcher.matches();
    }

    public boolean nullPassword(SignUpDTO userSignUpDto){
        return userSignUpDto.getPassword() == null;
    }
}
