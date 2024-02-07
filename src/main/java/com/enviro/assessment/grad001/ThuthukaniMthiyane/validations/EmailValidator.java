package com.enviro.assessment.grad001.ThuthukaniMthiyane.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;

public class EmailValidator {
    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^(?=.{1,50}$)[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public boolean validateEmail(SignUpDTO user) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(user.getEmail());
        return matcher.matches();
    }

    public boolean emailNull(SignUpDTO signUp){
        return signUp.getEmail() == null;
    }
}
