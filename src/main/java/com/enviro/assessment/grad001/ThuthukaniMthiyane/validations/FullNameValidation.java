package com.enviro.assessment.grad001.ThuthukaniMthiyane.validations;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNameValidation {
    private Pattern pattern;
    private Matcher matcher;
    private static final String NAME_PATTERN = "^[a-zA-Z0-9]{10,50} [a-zA-Z0-9]{1,39}$";
    public boolean validateName(SignUpDTO user) {
        pattern = Pattern.compile(NAME_PATTERN);
        matcher = pattern.matcher(user.getFullName());
        return matcher.matches();
    }
}
