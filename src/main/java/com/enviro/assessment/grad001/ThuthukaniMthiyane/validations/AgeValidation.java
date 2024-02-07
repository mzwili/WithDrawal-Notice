package com.enviro.assessment.grad001.ThuthukaniMthiyane.validations;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AgeValidation {
    private Pattern pattern;
    private Matcher matcher;
    String AGE_Pattern = "^([1-9][0-9]{1,}|[2-9])$";

    public boolean validateAge(SignUpDTO user) {
        pattern = Pattern.compile(AGE_Pattern);
        matcher = pattern.matcher(user.getAge());
        return matcher.matches();
    }
}
