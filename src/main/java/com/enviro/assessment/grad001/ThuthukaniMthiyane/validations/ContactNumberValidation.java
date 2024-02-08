package com.enviro.assessment.grad001.ThuthukaniMthiyane.validations;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactNumberValidation {
    private Pattern pattern;
    private Matcher matcher;
    private static final String CONTACT_PATTERN = "^(\\d{3} ?\\d{3} ?\\d{4}|\\d{10})$";

    public boolean validateContact(SignUpDTO user) {
        pattern = Pattern.compile(CONTACT_PATTERN);
        matcher = pattern.matcher(user.getContactNumber());
        return matcher.matches();
    }
}
