package com.microservice.authserve.service;

import com.microservice.authserve.dto.AuthUserDTO;
import com.microservice.authserve.dto.NewUserDto;
import com.microservice.authserve.dto.RequestDTO;
import com.microservice.authserve.dto.TokenDTO;
import com.microservice.authserve.entity.AuthUser;

public interface AuthUserService {

    //public AuthUserDTO login(AuthUserDTO authUserDTO);

    public AuthUser crear(NewUserDto newUserDto) throws Exception;

    public TokenDTO userLogin(AuthUserDTO dto);

    public TokenDTO validate(String token, RequestDTO dto);

}
