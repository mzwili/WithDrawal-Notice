package com.enviro.assessment.grad001.ThuthukaniMthiyane.interfaces;

import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignInDTO;
import com.enviro.assessment.grad001.ThuthukaniMthiyane.dto.SignUpDTO;

public interface UserService {
    void save(SignUpDTO signUpDTO);
    void userLogin(SignInDTO signUpDTO);
}
