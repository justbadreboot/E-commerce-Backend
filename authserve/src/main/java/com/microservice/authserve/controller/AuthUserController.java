package com.microservice.authserve.controller;

import com.microservice.authserve.dto.*;
import com.microservice.authserve.entity.AuthUser;
import com.microservice.authserve.service.AuthUserService;
import com.microservice.authserve.service.AuthUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthUserServiceImpl authUserService;


    @PostMapping("/login")
    private ResponseEntity<TokenDTO> login (@RequestBody LoginUserDTO authUserDTO){
        TokenDTO tokenDTO = authUserService.userLogin(authUserDTO);
        if (tokenDTO == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDTO);

    }

    @PostMapping("/validate")
    public ResponseEntity<TokenDTO> validate (@RequestParam String token, @RequestBody RequestDTO dto){
        TokenDTO tokenDTO = authUserService.validate(token, dto);
        if (tokenDTO ==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<AuthUser> create(@RequestBody NewUserDto dto) throws Exception {
        AuthUser authUser = authUserService.crear(dto);
        if (authUser == null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(authUser);
    }
}
