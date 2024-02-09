package com.enviro.assessment.grad001.ThuthukaniMthiyane.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignUpDTO {

    @NotBlank(message = "name is blank")
    private String fullName;
    @NotBlank(message = "age is blank")
    private String age;
    @Email(message = "Email invalid")
    private String email;
    @NotBlank(message = "Contact is blank")
    private String contactNumber;

    @NotBlank(message = "Password is blank")
    private String password;
    @NotBlank(message = "ConfirmPass is blank")
    private String confirmationPassword;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmationPassword() {
        return confirmationPassword;
    }

    public void setConfirmationPassword(String confirmationPassword) {
        this.confirmationPassword = confirmationPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
