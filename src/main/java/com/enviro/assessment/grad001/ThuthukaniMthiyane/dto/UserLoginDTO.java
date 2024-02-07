package com.enviro.assessment.grad001.ThuthukaniMthiyane.dto;

public class UserLoginDTO {
    private String email;
    private String password;

    public String getLogInEmail() {
        return email;
    }

    public void setLoginEmail(String email) {
        this.email = email;
    }

    public String getLogInPassword() {
        return password;
    }

    public void setLoginPassword(String password) {
        this.password = password;
    }
}
