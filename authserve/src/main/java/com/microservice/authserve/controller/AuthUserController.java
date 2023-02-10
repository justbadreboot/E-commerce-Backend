package com.microservice.authserve.controller;

import com.microservice.authserve.dto.*;
import com.microservice.authserve.entity.AuthUser;
import com.microservice.authserve.service.AuthUserService;
import com.microservice.authserve.service.AuthUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
@CrossOrigin(value = "*")
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
        log.info("entra al endpoint de validate");
        TokenDTO tokenDTO = authUserService.validate(token, dto);
        log.info("comprueba el token en auuthservice y validate");
        if (tokenDTO ==null){
            log.info("la respuesta del token es null");
            return ResponseEntity.badRequest().build();
        }
        log.info("validacion exitosa");
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
