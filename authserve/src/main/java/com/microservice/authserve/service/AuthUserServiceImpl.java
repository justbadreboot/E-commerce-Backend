package com.microservice.authserve.service;

import com.microservice.authserve.dto.AuthUserDTO;
import com.microservice.authserve.dto.NewUserDto;
import com.microservice.authserve.dto.RequestDTO;
import com.microservice.authserve.dto.TokenDTO;
import com.microservice.authserve.entity.AuthUser;
import com.microservice.authserve.repository.AuthUserRepository;
import com.microservice.authserve.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthUserServiceImpl{

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


   // @Autowired
   // private JwtProvider jwtProvider;



  //  @Override
    public AuthUser crear(NewUserDto newUserDto) throws Exception {
        Optional<AuthUser> user = authUserRepository.findByEmail(newUserDto.getEmail());
        if (user.isPresent()){
            return null;
        }
        AuthUser authUser = new AuthUser();
        mapeoDTOtoEntity(newUserDto, authUser);
        authUser.setPassword(passwordEncoder.encode(newUserDto.getPassword()));

        return authUserRepository.save(authUser);
    }

  //  @Override
    public TokenDTO userLogin(AuthUserDTO dto) {
        Optional<AuthUser> user = authUserRepository.findByEmail(dto.getEmail());
        if (!user.isPresent()){
            return null;
        }
        if (passwordEncoder.matches(dto.getPassword(), user.get().getPassword())){
            return new TokenDTO(JwtProvider.createToken(user.get()));
        }
        return null;
    }

  //  @Override
    public TokenDTO validate(String token, RequestDTO dto){
        if (!JwtProvider.validate(token, dto)){
            return null;
        }
        String email= JwtProvider.getEmailFromUser(token);
        if (!authUserRepository.findByEmail(email).isPresent()){
            return null;
        }
        return new TokenDTO(token);
    }


    public void mapeoDTOtoEntity(NewUserDto authUserDTO, AuthUser authUser){
        authUser.setEmail(authUserDTO.getEmail());
        authUser.setUsername(authUserDTO.getUsername());
        authUser.setPassword(authUserDTO.getPassword());
        authUser.setRole(authUserDTO.getRole());//aqui puedo setear el rol directamente de cliente al registrarse.
    }
}
